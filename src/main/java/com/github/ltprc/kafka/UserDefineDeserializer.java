package com.github.ltprc.kafka;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.util.SerializationUtils;

public class UserDefineDeserializer implements Deserializer<Object>{
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        System.out.println("configure");
    }
    @Override
    public Object deserialize(String topic, byte[] data) {
        return SerializationUtils.deserialize(data);
    }
    @Override
    public void close() {
        System.out.println("close");
    }
}
