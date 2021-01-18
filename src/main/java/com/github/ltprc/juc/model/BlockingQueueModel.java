package com.github.ltprc.juc.model;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
/**
 * ʹ��BlockingQueueʵ��������������ģ��
 * @author ZGJ
 * @date 2017��6��29��
 */
public class BlockingQueueModel {
    private static Integer count = 0;
    //����һ����������
    final BlockingQueue blockingQueue = new ArrayBlockingQueue<>(10);
    public static void main(String[] args) {
        BlockingQueueModel blockingQueueModel = new BlockingQueueModel();
        new Thread(blockingQueueModel.new Producer()).start();
        new Thread(blockingQueueModel.new Consumer()).start();
        new Thread(blockingQueueModel.new Producer()).start();
        new Thread(blockingQueueModel.new Consumer()).start();
        new Thread(blockingQueueModel.new Producer()).start();
        new Thread(blockingQueueModel.new Consumer()).start();
        new Thread(blockingQueueModel.new Producer()).start();
        new Thread(blockingQueueModel.new Consumer()).start();
    }
    class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    blockingQueue.put(1);
                    count++;
                    System.out.println(Thread.currentThread().getName()
                            + "������������Ŀǰ�ܹ���" + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    class Consumer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                try {
                    blockingQueue.take();
                    count--;
                    System.out.println(Thread.currentThread().getName()
                            + "���������ѣ�Ŀǰ�ܹ���" + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
