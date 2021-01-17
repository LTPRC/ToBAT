package com.github.ltprc.algorithm.lru;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LFUCache<K, V> {
    private final static int READ_LOCK_FLAG = 1;
    private final static int WRITE_LOCK_FLAG = 1 << 1;
    private final ReadWriteLock rwlock = new ReentrantReadWriteLock();  
    private final Lock readLock = rwlock.readLock();  
    private final Lock writeLock = rwlock.writeLock();  

    private class Node implements Comparable<Node> {
        int count;
        K key;
        V value;

        public Node(K key, V value) {
            this.count = 1;
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(LFUCache<K, V>.Node o) {
            return this.count - o.count;
        }
        
        private void addCount() {
            count++;
        }
    }

    private int capacity;
    //lituo使用优先队列+HashMap的数据结构解决这个问题
    private final HashMap<K, Node> hm = new HashMap<K, Node>(); 
    private final PriorityQueue<Node> queue = new PriorityQueue<>();

    // @param capacity, an integer
    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    // @return
    public V get(K key) {
        int lockFlag = 0;
        try {
            readLock.lock();
            lockFlag ^= READ_LOCK_FLAG;
            if (!hm.containsKey(key)) {
                return null;
            }
            readLock.unlock();
            lockFlag ^= READ_LOCK_FLAG;
            writeLock.lock();
            lockFlag ^= WRITE_LOCK_FLAG;
            Node current = hm.get(key);
            current.addCount();
            return current.value;
        } finally {
            releaseLock(lockFlag);
        }
    }

    // @param key
    // @param value
    public void set(K key, V value) {
        int lockFlag = 0;
        try {
            writeLock.lock();
            lockFlag ^= WRITE_LOCK_FLAG;
            if (get(key) != null) {
                Node current = hm.get(key);
                current.value = value;
                current.addCount();
                return;
            }
            Node insert = new Node(key, value);
            hm.put(key, insert);
            queue.add(insert);
            while (hm.size() > capacity) {
                hm.remove(queue.poll().key);
            }
        } finally {
            releaseLock(lockFlag);
        }
    }

    //lituo自创方法，根据锁flag的bit位释放对应的锁
    private void releaseLock(int lockFlag) {
        if ((lockFlag & READ_LOCK_FLAG) != 0) {
            readLock.unlock();
            lockFlag ^= READ_LOCK_FLAG;
        }
        if ((lockFlag & WRITE_LOCK_FLAG) != 0) {
            writeLock.unlock();
            lockFlag ^= WRITE_LOCK_FLAG;
        }
    }
}
