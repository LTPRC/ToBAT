package com.github.ltprc.algorithm.lru;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LRUCacheLHMThreadSafe<K, V> extends LinkedHashMap<K, V> {
    private final ReadWriteLock rwlock = new ReentrantReadWriteLock();  
    private final Lock readLock = rwlock.readLock();  
    private final Lock writeLock = rwlock.writeLock();  
    private int cacheSize;
    public LRUCacheLHMThreadSafe(int cacheSize) {
        super(16, 0.75F, true);
        this.cacheSize = cacheSize;
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() >= cacheSize;
    }
    @Override
    public boolean containsKey(Object key) {
        try {
            readLock.lock();
            return super.containsKey(key);
        } finally { 
            readLock.unlock();
        }
    }
    @Override
    public V get(Object key) {
        try {
            readLock.lock();
            return super.get(key);
        } finally { 
            readLock.unlock();
        }
    }
    @Override
    public V put(K key, V value) {
        try {
            writeLock.lock();
            return super.put(key, value);
        } finally {  
            writeLock.unlock(); 
        }
    }
    @Override
    public int size() {
        try {
            readLock.lock();
            return super.size();
        } finally {
            readLock.unlock();
        }
    }
    @Override
    public void clear() {
        try {
            writeLock.lock();
            super.clear();
        } finally { 
            writeLock.unlock(); 
        }
    }
    public Collection<Map.Entry<K, V>> getAll() {
        try {
            readLock.lock();
            return new ArrayList<Map.Entry<K, V>>(super.entrySet());
        } finally { 
            readLock.unlock();
        }
    }
}
