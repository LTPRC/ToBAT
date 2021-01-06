package com.github.ltprc.juc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * ʵ��һ���������ṩ����������add(), size()
 * д�����̣߳��߳�1���10��Ԫ�ص������У��߳�2ʵ�ּ��Ԫ�صĸ�������Ԫ�ظ�����5��ʱ���߳�2������ʾ��������ء�
 * @author tuoli
 *
 */
public class ContainerWithoutVolatile {
//  List lists = new ArrayList<>();
    volatile List lists = new ArrayList<>();
//    List lists = Collections.synchronizedList(new ArrayList<>());
    public void add(Object o) {
        lists.add(o);
    }
    public int size() {
        return lists.size();
    }
    public static void main(String[] args) {
        ContainerWithoutVolatile c = new ContainerWithoutVolatile();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                c.add(new Object());
                System.out.println("add " + i);
                try {
                    TimeUnit.SECONDS.sleep(1L);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }, "t1").start();
        new Thread(() -> {
            while (true) {
                if (c.size() == 5) {
                    break;
                }
            }
            System.out.println("t2 ends");
        }, "t2").start();
    }
}
