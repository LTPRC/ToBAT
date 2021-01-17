package com.github.ltprc.algorithm.lru;

import java.util.HashMap;

public class LRUCache<K, V> {
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
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    //在get时，如果存在，只需把对应item更新到tail.prev位置即可。
    public V get(K key) {
        if (!hm.containsKey(key)) {
            return null;
        }
        Node current = hm.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;

        moveToTail(current);

        return hm.get(key).value;
    }

    //在set时，如果超出capacity，则删除head.next位置的item, 同时将要插入的item放入tail.prev位置。

    // @param key
    // @param value
    // @return nothing
    public void set(K key, V value) {
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
    }

    //这样set与get均为O(1)时间的操作（HashMap Get/Set + LinkedList Insert/Delete)，空间复杂度为O(n), n为capacity.
    private void moveToTail(Node current) {
        current.next = tail;
        tail.prev.next = current;
        current.prev = tail.prev;
        tail.prev = current;
    }
}
