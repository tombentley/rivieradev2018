/*
 * Copyright 2018, Strimzi authors.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package com.github.tombentley.rivieradev2018.serdes;

import com.github.tombentley.rivieradev2018.model.Order;
import com.github.tombentley.rivieradev2018.model.PaymentResult;
import com.github.tombentley.rivieradev2018.model.StockReserved;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public abstract class JacksonSerdes<T> implements Serde<T> {

    private final Class<T> cls;
    private final JacksonSerializer<T> serializer;
    private final JacksonDerserializer<T> deserializer;

    JacksonSerdes(Class<T> cls) {
        this.cls = cls;
        this.serializer = new JacksonSerializer<>(cls);
        this.deserializer = new JacksonDerserializer<>(cls);
    }

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public void close() {

    }

    @Override
    public Serializer<T> serializer() {
        return serializer;
    }

    @Override
    public Deserializer<T> deserializer() {
        return deserializer;
    }

    public static class OrderSerdes extends JacksonSerdes<Order> {
        public OrderSerdes() {
            super(Order.class);
        }
    }

    public static OrderSerdes Order() {
        return new OrderSerdes();
    }

    public static class StockReservedSerdes extends JacksonSerdes<StockReserved> {
        public StockReservedSerdes() {
            super(StockReserved.class);
        }
    }

    public static StockReservedSerdes StockReserved() {
        return new StockReservedSerdes();
    }

    public static class PaymentResultSerdes extends JacksonSerdes<PaymentResult> {
        PaymentResultSerdes() {
            super(PaymentResult.class);
        }
    }

    public static PaymentResultSerdes PaymentResult() {
        return new PaymentResultSerdes();
    }
}
