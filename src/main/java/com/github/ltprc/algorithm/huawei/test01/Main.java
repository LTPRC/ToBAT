package com.github.ltprc.algorithm.huawei.test01;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * ��Ŀ����
 * ...
 * 
 * ����������
 * ...
 * 
 * ���������
 * ...
 * 
 * ������ʾ��
 * �ύ��ʱ����Ҫ�����ύimport���
 * ������ȷ��ΪMain�Ҳ�Ҫʹ��public��������η���
 * @author tuoli
 *
 */
public class Main {
    static class Fruit implements Comparable<Fruit> {
        int m;
        int n;
        public Fruit(int m, int n) {
            this.m = m;
            this.n = n;
        }
        @Override
        public int compareTo(Fruit o) {
            return this.m - o.m;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s1 = in.nextLine();
            String[] strs1 = s1.split(",");
            int count = strs1.length;
            String s2 = in.nextLine();
            String[] strs2 = s2.split(",");
            Queue<Fruit> q = new PriorityQueue<>();
            for (int i = 0; i < count; i++) {
                int m = Integer.parseInt(strs1[i]);
                int n = Integer.parseInt(strs2[i]);
                if (n > m) {
                    q.add(new Fruit(m, n));
                }
            }
            String s3 = in.nextLine();
            int k = Integer.parseInt(s3);
            /**
             * ע�⣬���������Ƚ������ټ�����
             */
            while (!q.isEmpty()) {
                Fruit next = q.poll();
                if (next.m > k) {
                    break;
                }
                k += next.n - next.m;
            }
            System.out.println(k);
        }
    }
}
