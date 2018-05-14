/*
 * Copyright 2018, Strimzi authors.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package com.github.tombentley.rivieradev2018.driver;

import com.github.tombentley.rivieradev2018.model.Order;
import com.github.tombentley.rivieradev2018.model.Utils;
import com.github.tombentley.rivieradev2018.serdes.JacksonSerdes;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Iterator;
import java.util.Properties;

/**
 * Produces random Orders to the topic {@code order.create}
 * a rate of about 1 per second.
 */
public class OrderDriver {

    public static void main(String[] args) throws InterruptedException {
        final String topic = "order.created";
        KafkaProducer<Long, Order> producer = createOrdersProducer();
        for (Order order : randomOrders()) {
            ProducerRecord<Long, Order> record = new ProducerRecord<>(topic, order.getOrderId(), order);
            System.out.println("Sending " + record);
            producer.send(record);
            Thread.sleep(1_000L);
        }
    }

    private static KafkaProducer<Long, Order> createOrdersProducer() {
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        //properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "");
        //properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "");
        Serializer<Long> keySerializer = Serdes.Long().serializer();
        Serializer<Order> valueSerializer = JacksonSerdes.Order().serializer();

        return new KafkaProducer<>(properties, keySerializer, valueSerializer);
    }

    public static Iterable<Order> randomOrders() {
        return () -> new Iterator<Order>() {
            @Override
            public boolean hasNext() {
                return true;
            }
            @Override
            public Order next() {
                return Utils.randomOrder();
            }
        };
    }

}
