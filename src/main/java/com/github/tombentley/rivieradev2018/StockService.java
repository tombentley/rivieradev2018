/*
 * Copyright 2018, Strimzi authors.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package com.github.tombentley.rivieradev2018;

import com.github.tombentley.rivieradev2018.model.Order;
import com.github.tombentley.rivieradev2018.model.PaymentResult;
import com.github.tombentley.rivieradev2018.model.Product;
import com.github.tombentley.rivieradev2018.model.StockReserved;
import com.github.tombentley.rivieradev2018.model.Utils;
import com.github.tombentley.rivieradev2018.serdes.JacksonSerdes;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.Consumed;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Produced;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Consumes Orders, checks stock DB,
 * produces StockReserved or UnsufficientStock
 * Consumes PaymentSuccess, decrements stock
 * Consumes PaymentFailure, cancels StockReserved
 */
public class StockService {

    public static void main(String[] args) {
        // A local DB of stock
        Map<Product, Integer> stock = new HashMap<>();
        for (Product p : Utils.products()) {
            stock.put(p, 10_000);
        }
        stock.put(Utils.products().get(0), 10);


        System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "info");
        System.setProperty("org.slf4j.simpleLogger.showThreadName", "false");

        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "stock-service");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.Long().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, JacksonSerdes.Order().getClass());

        StreamsBuilder builder = new StreamsBuilder();

        KStream<Long, Order> orders = builder.stream("order.created");
        orders.map((orderId, order) -> {
            boolean sufficientStock = true;
            List<Order.LineItem> items = order.getItems();
            Map<Product, Integer> updateMap = new HashMap<>(items.size());
            synchronized (stock) {
                for (Order.LineItem lineItem : items) {
                    int currentStock = stock.get(lineItem.getProduct());
                    int remainingStock = currentStock - lineItem.getQuantity();
                    if (remainingStock >= 0) {
                        updateMap.put(lineItem.getProduct(), remainingStock);
                    } else {
                        sufficientStock = false;
                        break;
                    }
                }
                if (sufficientStock) {
                    stock.putAll(updateMap);
                }
            }
            StockReserved stockReserved = new StockReserved(orderId, sufficientStock);
            System.out.println(stockReserved);
            return new KeyValue<>(orderId, stockReserved);
        }).to("stock.reserved", Produced.with(Serdes.Long(), JacksonSerdes.StockReserved()));

        KTable<Long, Order> ordersTable = orders.groupByKey().reduce((a, b) -> b);

        // When payments fail, restore the stock they were reserved
        builder.<Long, PaymentResult>stream("payment.result", Consumed.with(Serdes.Long(), JacksonSerdes.PaymentResult()))
                .filter((orderId, pr) -> !pr.isSucceeded())
                .join(ordersTable, (paymentResult, order) -> order)
                .foreach((orderId, order) -> {
                    List<Order.LineItem> items = order.getItems();
                    System.out.println("Restoring items to stock " + items);
                    synchronized (stock) {
                        for (Order.LineItem lineItem : items) {
                            int currentStock = stock.get(lineItem.getProduct());
                            stock.put(lineItem.getProduct(), currentStock + lineItem.getQuantity());
                        }
                    }
                });

        KafkaStreams streams = new KafkaStreams(builder.build(), props);
        streams.start();
    }

    private static PaymentResult processPayment(Order order) {
        // Really we would do things like process credit card payments etc here
        // But for the demo the bank is having a bad day...
        boolean paymentSucceeded = order.getCreditCardDetails().getCardNumber() % 2 == 1;

        return new PaymentResult(order.getOrderId(), paymentSucceeded);
    }
}
