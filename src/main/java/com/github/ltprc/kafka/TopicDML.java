package com.github.ltprc.kafka;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.DeleteTopicsResult;
import org.apache.kafka.clients.admin.DescribeTopicsResult;
import org.apache.kafka.clients.admin.KafkaAdminClient;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.admin.TopicDescription;

public class TopicDML {
    private static KafkaAdminClient adminClient;
    public static void init() {
        Properties props = new Properties();
        props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConfig.KAFKA_HOST + ":" + KafkaConfig.KAFKA_PORT);
        adminClient = (KafkaAdminClient) KafkaAdminClient.create(props);
    }
    public static void close() {
        adminClient.close();
    }
    public static void listTopic() throws InterruptedException, ExecutionException {
        ListTopicsResult topicsResult =  adminClient.listTopics();
        Set<String> names = topicsResult.names().get();
        for (String name : names) {
            System.out.println(name);
        }
    }
    public static void createTopic(String name, int numPartitions, short replicationFactor) throws InterruptedException, ExecutionException {
        createTopic(name, numPartitions, replicationFactor, false);
    }
    public static void createTopic(String name, int numPartitions, short replicationFactor, boolean isAsync) throws InterruptedException, ExecutionException {
        CreateTopicsResult createTopicsResult = adminClient.createTopics(Arrays.asList(new NewTopic(name, numPartitions, replicationFactor)));
        //如果是同步处理，会立即看到结果
        if (!isAsync) {
            createTopicsResult.all().get();
        }
    }
    public static void deleteTopic(List<String> names) throws InterruptedException, ExecutionException {
        deleteTopic(names, false);
    }
    public static void deleteTopic(List<String> names, boolean isAsync) throws InterruptedException, ExecutionException {
        DeleteTopicsResult deleteTopicsResult = adminClient.deleteTopics(names);
        //如果是同步处理，会立即看到结果
        if (!isAsync) {
            deleteTopicsResult.all().get();
        }
    }
    public static void describeTopic(List<String> names) throws InterruptedException, ExecutionException {
        DescribeTopicsResult dtr =  adminClient.describeTopics(names);
        Map<String, TopicDescription> topicDescriptionMap = dtr.all().get();
        for (Entry<String, TopicDescription> entry : topicDescriptionMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
    public static void main(String[] args) {
        System.out.println("Kafka client is initiating...");
        init();
        System.out.println("Kafka topics are listing...");
        try {
//            createTopic("topic101", 5, (short)1);
//            deleteTopic(Arrays.asList("topic101", "topic102"));
            listTopic();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Kafka client is closing...");
        close();
    }

}
