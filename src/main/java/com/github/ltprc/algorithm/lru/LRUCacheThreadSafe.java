package com.github.ltprc.algorithm.lru;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LRUCacheThreadSafe<K, V> {
    private final static int READ_LOCK_FLAG = 1;
    private final static int WRITE_LOCK_FLAG = 1 << 1;
    private final ReadWriteLock rwlock = new ReentrantReadWriteLock();  
    private final Lock readLock = rwlock.readLock();  
    private final Lock writeLock = rwlock.writeLock();  

    private class Node {
        Node prev;
        Node next;
        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    private int capacity;
    private HashMap<K, Node> hm = new HashMap<K, Node>(); 
    //双向链表比数组更有利于Insert和Delete的操纵，所以使用链表记录时间顺序下的数据。此外，需要记录链表的head和tail，从而方便进行移动到tail或者删除head的操作：
    // head和tail本身内容没有含义，head.next作为最近最少使用的item, tail.prev为最近使用过的item.
    private Node head = new Node(null, null);
    private Node tail = new Node(null, null);

    // @param capacity, an integer
    public LRUCacheThreadSafe(int capacity) {
        this.capacity = capacity;
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    //在get时，如果存在，只需把对应item更新到tail.prev位置即可。
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
            current.prev.next = current.next;
            current.next.prev = current.prev;

            moveToTail(current);

            return hm.get(key).value;
        } finally {
            releaseLock(lockFlag);
        }
    }

    //在set时，如果超出capacity，则删除head.next位置的item, 同时将要插入的item放入tail.prev位置。

    // @param key
    // @param value
    // @return nothing
    public void set(K key, V value) {
        int lockFlag = 0;
        try {
            writeLock.lock();
            lockFlag ^= WRITE_LOCK_FLAG;
            if (get(key) != null) {
                hm.get(key).value = value;
                return;
            }
            if (hm.size() == capacity) {
                hm.remove(head.next.key);
                head.next = head.next.next;
                head.next.prev = head;
            }
    
            Node insert = new Node(key, value);
            hm.put(key, insert);
            moveToTail(insert);
        } finally {
            releaseLock(lockFlag);
        }
    }

    //这样set与get均为O(1)时间的操作（HashMap Get/Set + LinkedList Insert/Delete)，空间复杂度为O(n), n为capacity.
    private void moveToTail(Node current) {
        current.next = tail;
        tail.prev.next = current;
        current.prev = tail.prev;
        tail.prev = current;
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
