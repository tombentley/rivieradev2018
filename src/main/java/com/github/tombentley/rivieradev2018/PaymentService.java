/*
 * Copyright 2018, Strimzi authors.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package com.github.tombentley.rivieradev2018;

import com.github.tombentley.rivieradev2018.model.Order;
import com.github.tombentley.rivieradev2018.model.PaymentResult;
import com.github.tombentley.rivieradev2018.model.StockReserved;
import com.github.tombentley.rivieradev2018.serdes.JacksonSerdes;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.Consumed;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Produced;

import java.util.Properties;

/**
 * Consumes: Orders, StockReserved (join)
 * Produces: PaymentSuccess or PaymentFailure
 */
public class PaymentService {

    public static void main(String[] args) {
        System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "info");
        System.setProperty("org.slf4j.simpleLogger.showThreadName", "false");

        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "payment-service");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.Long().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, JacksonSerdes.Order().getClass());

        StreamsBuilder builder = new StreamsBuilder();

        // Keep a local database of orderId -> order
        KTable<Long, Order> orders = builder.<Long, Order>stream("order.created")
                .groupByKey()
                .reduce((a, b) -> b);

        builder.<Long, StockReserved>stream("stock.reserved",
                    Consumed.with(Serdes.Long(), JacksonSerdes.StockReserved()))
                // Only attempt payment if we have enough stock to fulfill the order
                .filter((orderId, sr) -> sr.isSufficientStock())
                // Match the order with the stock check
                .join(orders, (reservation, order) -> processPayment(order))
                .to("payment.result", Produced.with(Serdes.Long(), JacksonSerdes.PaymentResult()));

        KafkaStreams streams = new KafkaStreams(builder.build(), props);
        streams.start();
    }

    private static PaymentResult processPayment(Order order) {
        // Really we would do things like process credit card payments etc here
        // But for the demo the bank is having a bad day...
        System.out.println(order.getCreditCardDetails());
        boolean paymentSucceeded = order.getCreditCardDetails().getCvc() % 2 == 1;
        System.out.println("Order " + order.getOrderId() + " payment success? " + paymentSucceeded);
        return new PaymentResult(order.getOrderId(), paymentSucceeded);
    }
}
