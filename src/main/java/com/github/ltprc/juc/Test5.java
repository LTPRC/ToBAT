package com.github.ltprc.juc;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * ʹ�ùܵ�ʵ��������������ģ��
 * @author ZGJ
 * @date 2017��6��30��
 */
public class Test5 {
    final PipedInputStream pis = new PipedInputStream();
    final PipedOutputStream pos = new PipedOutputStream();
    {
        try {
            pis.connect(pos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    class Producer implements Runnable {
        @Override
        public void run() {
            try {
                while(true) {
                    Thread.sleep(1000);
                    int num = (int) (Math.random() * 255);
                    System.out.println(Thread.currentThread().getName() + "������������һ�����֣�������Ϊ�� " + num);
                    pos.write(num);
                    pos.flush();
                } 
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    pos.close();
                    pis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    class Consumer implements Runnable {
        @Override
        public void run() {
            try {
                while(true) {
                    Thread.sleep(1000);
                    int num = pis.read();
                    System.out.println("������������һ�����֣�������Ϊ��" + num);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    pos.close();
                    pis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        Test5 test5 = new Test5();
        new Thread(test5.new Producer()).start();
        new Thread(test5.new Consumer()).start();
    }
}
