package com.github.ltprc.algorithm.lru;

public class LRUTest {

    public static void main(String[] args) {
        LRUCache<Integer, Integer> cache1 = new LRUCache<>(2);
        cache1.set(1,10);
        cache1.set(2,20);
        cache1.set(3,30);
        System.out.println(cache1.get(1));
        System.out.println(cache1.get(3));

        LRUCacheThreadSafe<Integer, Integer> cache2 = new LRUCacheThreadSafe<>(2);
        cache2.set(1,10);
        cache2.set(2,20);
        cache2.set(3,30);
        System.out.println(cache2.get(1));
        System.out.println(cache2.get(3));

        LRUCacheLHM<Integer, Integer> cache3 = new LRUCacheLHM<>(2);
        cache3.put(1,10);
        cache3.put(2,20);
        cache3.put(3,30);
        System.out.println(cache3.get(1));
        System.out.println(cache3.get(3));

        LRUCacheLHMThreadSafe<Integer, Integer> cache4 = new LRUCacheLHMThreadSafe<>(2);
        cache4.put(1,10);
        cache4.put(2,20);
        cache4.put(3,30);
        System.out.println(cache4.get(1));
        System.out.println(cache4.get(3));

    }

}
