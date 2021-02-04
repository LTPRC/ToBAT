package com.github.ltprc.algorithm.huawei.HJ24;

import java.util.Scanner;

/**
 * TODO 测试不过 题目又抽风了
 * 
 * 题目描述
 * 计算最少出列多少位同学，使得剩下的同学排成合唱队形
说明：
N位同学站成一排，音乐老师要请其中的(N-K)位同学出列，使得剩下的K位同学排成合唱队形。
合唱队形是指这样的一种队形：设K位同学从左到右依次编号为1，2…，K，他们的身高分别为T1，T2，…，TK，   则他们的身高满足存在i（1<=i<=K）使得T1<T2<......<Ti-1<Ti>Ti+1>......>TK。
你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
 * 
 * 输入描述：
 * 整数N
 * 
 * 输出描述：
 * 最少需要几位同学出列
 * 
 * 友情提示：
 * 提交答案时，不要忘记提交import命令。
 * 类名称确保为Main且不要使用public以外的修饰符。
 * @author tuoli
 *
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int count = Integer.parseInt(s);
        if (count == 0) {
            System.out.println(0);
        }
        s = in.nextLine();
        String[] strs = s.split(" ");
        /**
         * 思路，左遍历一遍排座次，右遍历一遍排座次，累加减一就是最长人数。
         */
        int[] rst1 = new int[count];
        int[] rst2 = new int[count];
        for (int i = 0; i < count; i++) {
            rst1[i] = 1;
            for (int j = 0; j < i; j++) {
                if (Integer.parseInt(strs[j]) < Integer.parseInt(strs[i])) {
                    rst1[i] = Math.max(rst1[i], rst1[j] + 1);
                }
            }
        }
        for (int i = count - 1; i >= 0; i--) {
            rst2[i] = 1;
            for (int j = count - 1; j > i; j--) {
                if (Integer.parseInt(strs[j]) < Integer.parseInt(strs[i])) {
                    rst2[i] = Math.max(rst2[i], rst2[j] + 1);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < count; i++) {
            max = Math.max(max, rst1[i] + rst2[i] - 1);
        }
        System.out.println(count - max);
        System.out.println(count - max);
    }
}
