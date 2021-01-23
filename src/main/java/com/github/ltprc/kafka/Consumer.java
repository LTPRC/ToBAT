package com.github.ltprc.kafka;

import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Properties;
import java.util.regex.Pattern;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class Consumer {
    private static KafkaConsumer<String, String> consumer;
    public static void init(String groupId) {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConfig.KAFKA_HOST + ":" + KafkaConfig.KAFKA_PORT);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        consumer = new KafkaConsumer<String, String>(props);
    }
    public static void close() {
        consumer.close();
    }
    public static void main(String[] args) {
        init("group1");
        consumer.subscribe(Pattern.compile("^topic.*"));
//        consumer.subscribe(Arrays.asList("topic01"));
        ConsumerRecords consumerRecords = consumer.poll(Duration.ofMillis(100));
        while (consumerRecords.isEmpty()) {
            Iterator<ConsumerRecord<String, String>> recordIterator = consumerRecords.iterator();
            while (consumerRecords.isEmpty()) {
                while (recordIterator.hasNext()) {
                    ConsumerRecord<String, String> record = recordIterator.next();
                    System.out.println("Receive: topic-" + record.topic() + " partition-" + record.partition() + " offset-" + record.offset() 
                    + " key-" + record.key() + " value-" + record.value());
                }
            }
            consumerRecords = consumer.poll(Duration.ofMillis(100));
        };
        close();
    }
}
