package com.github.ltprc.kafka;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.utils.Utils;

public class UserDefinePartitioner implements Partitioner {
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        int numPartitions = cluster.partitionsForTopic(topic).size();
        if (keyBytes == null || keyBytes.length == 0) {
            return atomicInteger.addAndGet(1) & Integer.MAX_VALUE % numPartitions;
        } else {
            return Utils.toPositive(Utils.murmur2(keyBytes)) % numPartitions;
        }
    }
    @Override
    public void close() {
        System.out.println("close");
    }
    @Override
    public void configure(Map<String, ?> configs) {
        System.out.println("configure");
    }
}
