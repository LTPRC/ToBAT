package com.github.ltprc.juc.model;

import java.util.concurrent.Semaphore;
/**
 * ʹ��semaphore�ź���ʵ��
 * @author ZGJ
 * @date 2017��6��29��
 */
public class SemaphoreModel {
    private static Integer count = 0;
    //���������ź���
    final Semaphore notFull = new Semaphore(10);
    final Semaphore notEmpty = new Semaphore(0);
    final Semaphore mutex = new Semaphore(1);
    public static void main(String[] args) {
        SemaphoreModel semaphoreModel = new SemaphoreModel();
        new Thread(semaphoreModel.new Producer()).start();
        new Thread(semaphoreModel.new Consumer()).start();
        new Thread(semaphoreModel.new Producer()).start();
        new Thread(semaphoreModel.new Consumer()).start();
        new Thread(semaphoreModel.new Producer()).start();
        new Thread(semaphoreModel.new Consumer()).start();
        new Thread(semaphoreModel.new Producer()).start();
        new Thread(semaphoreModel.new Consumer()).start();
    }
    class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    notFull.acquire();
                    mutex.acquire();
                    count++;
                    System.out.println(Thread.currentThread().getName()
                            + "������������Ŀǰ�ܹ���" + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    mutex.release();
                    notEmpty.release();
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
                    notEmpty.acquire();
                    mutex.acquire();
                    count--;
                    System.out.println(Thread.currentThread().getName()
                            + "���������ѣ�Ŀǰ�ܹ���" + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    mutex.release();
                    notFull.release();
                }
            }
        }
    }
}
