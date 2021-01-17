package com.github.ltprc.algorithm.lru;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheLHM<K, V> extends LinkedHashMap<K, V> {
    private int cacheSize;
    public LRUCacheLHM(int cacheSize) {
        super(16, 0.75F, true);
        this.cacheSize = cacheSize;
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() >= cacheSize;
    }
}
