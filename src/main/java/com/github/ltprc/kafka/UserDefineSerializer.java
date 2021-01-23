package com.github.ltprc.kafka;

import java.io.Serializable;
import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;
import org.springframework.util.SerializationUtils;

public class UserDefineSerializer implements Serializer<Object>{
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        System.out.println("configure");
    }
    @Override
    public byte[] serialize(String topic, Object data) {
        return SerializationUtils.serialize((Serializable) data);
    }
    @Override
    public void close() {
        System.out.println("close");
    }
}
