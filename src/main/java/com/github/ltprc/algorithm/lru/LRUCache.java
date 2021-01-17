package com.github.ltprc.algorithm.lru;

import java.util.HashMap;

public class LRUCache {
    private class Node {
        Node prev;
        Node next;
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> hm = new HashMap<Integer, Node>(); 
    //˫������������������Insert��Delete�Ĳ��ݣ�����ʹ�������¼ʱ��˳���µ����ݡ����⣬��Ҫ��¼�����head��tail���Ӷ���������ƶ���tail����ɾ��head�Ĳ�����
    // head��tail��������û�к��壬head.next��Ϊ�������ʹ�õ�item, tail.prevΪ���ʹ�ù���item.
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);

    // @param capacity, an integer
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    //��getʱ��������ڣ�ֻ��Ѷ�Ӧitem���µ�tail.prevλ�ü��ɡ�
    // @return an integer
    public int get(int key) {
        if (!hm.containsKey(key)) {
            return -1;
        }
        Node current = hm.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;

        moveToTail(current);

        return hm.get(key).value;
    }

    //��setʱ���������capacity����ɾ��head.nextλ�õ�item, ͬʱ��Ҫ�����item����tail.prevλ�á�

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        if (get(key) != -1) {
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

    //����set��get��ΪO(1)ʱ��Ĳ�����HashMap Get/Set + LinkedList Insert/Delete)���ռ临�Ӷ�ΪO(n), nΪcapacity.
    private void moveToTail(Node current) {
        current.next = tail;
        tail.prev.next = current;
        current.prev = tail.prev;
        tail.prev = current;
    }
}
