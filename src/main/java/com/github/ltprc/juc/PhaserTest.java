package com.github.ltprc.juc;

import java.util.concurrent.Phaser;

public class PhaserTest extends Phaser {
    @Override
    protected boolean onAdvance(int phase, int registeredParties) { //在每个阶段执行完成后回调的方法
        switch (phase) {
        case 0:
            return haveAppetizer();
        case 1:
            return haveDinner();
        case 2:
            return haveDessert();
        }
        return true;
    }
    private boolean haveAppetizer(){
        System.out.println(getRegisteredParties() + " people have had appetizer.");
        return false;
    }
    private boolean haveDinner(){
        System.out.println(getRegisteredParties() + " people have had dinner.");
        return false;
    }
    private boolean haveDessert(){
        System.out.println(getRegisteredParties() + " people have had dessert.");
        return true;
    }
    static class CustomerTask implements Runnable {
        private Phaser phaser;
        public CustomerTask(Phaser phaser) {
            this.phaser = phaser;
        }
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+" is arrived.");
            phaser.arriveAndAwaitAdvance();
            System.out.println(Thread.currentThread().getName()+" is to have appetizer.");
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" have had appetizer.");
            phaser.arriveAndAwaitAdvance();
            System.out.println(Thread.currentThread().getName()+" is to have dinner.");
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" have had dinner.");
            phaser.arriveAndAwaitAdvance();
            System.out.println(Thread.currentThread().getName()+" is to have dessert.");
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" have had dessert.");
            phaser.arriveAndAwaitAdvance();
        }
    }
    public static void main(String[] args) {
        PhaserTest phaser = new PhaserTest();
        CustomerTask[] customerTasks = new CustomerTask[5];
        for (int i = 0; i < customerTasks.length; i++) {
            customerTasks[i] = new CustomerTask(phaser);
            phaser.register();
        }
        Thread[] threads = new Thread[customerTasks.length];
        for (int i = 0; i < customerTasks.length; i++) {
            threads[i] = new Thread(customerTasks[i], "Customer " + i);
            threads[i].start();
        }
    }
}
