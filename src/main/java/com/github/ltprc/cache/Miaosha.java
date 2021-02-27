package com.github.ltprc.cache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class Miaosha {

    public static void main(String[] args) {    
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(10);
        jedisPoolConfig.setMaxWaitMillis(10000);
        jedisPoolConfig.setMaxTotal(1024);

        JedisPool jedisPool = new JedisPool(jedisPoolConfig, "127.0.0.1", 6379);
        ExecutorService executor = Executors.newFixedThreadPool(30);
        for (int i = 0; i < 20; i++) {    
            executor.execute(new CustomerTask(i, jedisPool));    
        }
        executor.shutdown();    
    }
}

class CustomerTask implements Runnable {    

    private int customerId;    
    private JedisPool jedisPool;    

    public CustomerTask (int customerId, JedisPool jedisPool) {    
        this.customerId = customerId;    
        this.jedisPool = jedisPool;    
    }

    @Override
    public void run() {
        // ִ����ɱ    
        Jedis client = jedisPool.getResource();
        String productId = client.lpop("str");
        if (productId != null && productId.length() != 0) {
            System.out.println("�˿�" + customerId + "������" + productId + "����Ʒ");
        } else {
            System.out.println("�˿�" + customerId + "û��������Ʒ");
        }
    }
}
