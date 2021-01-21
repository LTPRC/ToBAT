package com.github.ltprc.algorithm;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.lang3.math.NumberUtils;

public class AntFinancialTest01 {
    final static int THREAD_COUNT = 2;
    final static int BEGIN_NUM = 1;
    final static int END_NUM = 4;
    final static long KEEP_ALIVE_TIME = 60L;
    final static Lock lock = new ReentrantLock();
    volatile static int num = BEGIN_NUM;

    public static void function1() {
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(THREAD_COUNT, THREAD_COUNT, KEEP_ALIVE_TIME, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(THREAD_COUNT), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < THREAD_COUNT; i++) {
            tpe.execute(new Task(i));
        }
        tpe.shutdown();
    }

    static class Task implements Runnable {
        int taskNum;

        public Task(int taskNum) {
            this.taskNum = taskNum;
        }

        @Override
        public void run() {
            while (num <= END_NUM) {
                try {
                    lock.lock();
                    while (num <= END_NUM && num % THREAD_COUNT == taskNum) {
                        System.out.println(num++);
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {

                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static List<Integer> function2(List<List<Integer>> lists) {
        List<Integer> rst = new LinkedList<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        if (lists == null || lists.isEmpty()) {
            return rst;
        }
        treeSet.addAll(lists.get(0));
        for (List<Integer> list : lists) {
            treeSet.retainAll(list);
            if (treeSet.isEmpty()) {
                return rst;
            }
        }
        rst.addAll(treeSet);
        return rst;
    }

    public static <T> void function3(List<T> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        sort(list, 0, list.size() - 1);
    }

    public static <T> void sort(List<T> list, int L, int R) {
        if (L >= R) {
            return;
        }
        int M = partition(list, L, R);
        sort(list, L, M - 1);
        sort(list, M + 1, R);
    }

    public static <T> int partition(List<T> list, int L, int R) {
        if (L > R) {
            return -1;
        }
        if (L == R) {
            return L;
        }
        int lessEqual = L - 1;
        int index = L;
        while (index < R) {
            if (compareMethod(list, index, R) <= 0) {
                swapMethod(list, index, ++lessEqual);
            }
            index++;
        }
        swapMethod(list, ++lessEqual, R);
        return lessEqual;
    }

    public static <T> int compareMethod(List<T> list, int L, int R) {
        T t1 = list.get(L);
        T t2 = list.get(R);
        //���÷�����T�Ƿ�ʵ��compareTo����
        Class clazz = t1.getClass();
        try {
            Method compareTo = clazz.getDeclaredMethod("compareTo", clazz);
            compareTo.setAccessible(true);
            return (int) compareTo.invoke(t1, t2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String s1 = "";
        String s2 = "";
        if (t1 == t2) {
            return 0;
        }
        if (t1 != null) {
            s1 = t1.toString();
        }
        if (t2 != null) {
            s2 = t2.toString();
        }
        if (NumberUtils.isCreatable(s1) && NumberUtils.isCreatable(s2)) {
            Double d1 = Double.valueOf(s1);
            Double d2 = Double.valueOf(s2);
            return d1.compareTo(d2);
        }
        return s1.compareTo(s2);
    }

    public static <T> void swapMethod(List<T> list, int L, int R) {
        T temp = list.get(L);
        list.set(L, list.get(R));
        list.set(R, temp);
    }

    public static void main(String[] args) {
//        String str ="";
//        "".compareTo("");

//        List<Integer> list1 = new ArrayList<>();
//        list1.add(10);
//        list1.add(15);
//        list1.add(30);
//        list1.add(354);
//        List<Integer> list2 = new ArrayList<>();
//        list2.add(20);
//        list2.add(25);
//        list2.add(28);
//        
//        List<Integer> rst = function2(list1, list2);
//        for (int i : rst) {
//            System.out.println(i);
//        }

//      List<Integer> list3 = new ArrayList<>();
//      list3.add(320);
//      list3.add(125);
//      list3.add(228);
//    function3(list3);
//    for (int i : list3) {
//        System.out.println(i);
//    }

        function1();
    }
}
