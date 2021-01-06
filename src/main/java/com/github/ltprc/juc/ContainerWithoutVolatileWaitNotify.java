package com.github.ltprc.juc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 实现一个容器，提供两个方法：add(), size()
 * 写两个线程，线程1添加10个元素到容器中，线程2实现监控元素的个数，当元素个数到5个时，线程2给出提示并结束监控。
 * @author tuoli
 *
 */
public class ContainerWithoutVolatileWaitNotify {
    List lists = new ArrayList<>();
    public void add(Object o) {
        lists.add(o);
    }
    public int size() {
        return lists.size();
    }
    public static void main(String[] args) {
        ContainerWithoutVolatileWaitNotify c = new ContainerWithoutVolatileWaitNotify();
        final Object lock = new Object();
        new Thread(() -> {
            synchronized (lock) {
                System.out.println("t2 starts");
                if (c.size() != 5) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                System.out.println("t2 ends");
            }
        }, "t2").start();
        try {
            TimeUnit.SECONDS.sleep(1L);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        new Thread(() -> {
            System.out.println("t1 starts");
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    c.add(new Object());
                    System.out.println("add " + i);
                    if (c.size() == 5) {
                        lock.notify();//notify不释放锁
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1L);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("t1 ends");
        }, "t1").start();
    }
}
