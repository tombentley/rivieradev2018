/*
 * Copyright 2018, Strimzi authors.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package com.github.tombentley.rivieradev2018.serdes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class JacksonSerializer<T> implements Serializer<T> {

    private final ObjectMapper mapper = new ObjectMapper();

    private final Class<T> cls;

    public JacksonSerializer(Class<T> cls) {
        this.cls = cls;
    }

    public void configure(Map<String, ?> map, boolean b) {
    }

    public byte[] serialize(String topic, T order) {
        try {
            if (!cls.isAssignableFrom(order.getClass())) {
                throw new RuntimeException("Expected to serialize a "  + cls.getName() + ", got a " + order.getClass().getName());
            }
            return mapper.writeValueAsBytes(order);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() {
    }
}
