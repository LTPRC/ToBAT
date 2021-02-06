package com.github.ltprc.algorithm.huawei.test01;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * 题目描述
 * ...
 * 
 * 输入描述：
 * ...
 * 
 * 输出描述：
 * ...
 * 
 * 友情提示：
 * 提交答案时，不要忘记提交import命令。
 * 类名称确保为Main且不要使用public以外的修饰符。
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
             * 注意，本题允许先结算卖再继续买
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
