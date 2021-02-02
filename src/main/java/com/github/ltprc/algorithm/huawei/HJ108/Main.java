package com.github.ltprc.algorithm.huawei.HJ108;

import java.util.Scanner;

/**
 * 题目描述
 * 正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数。
 * 
 * 输入描述：
 * 输入两个正整数A和B。
 * 
 * 输出描述：
 * 输出A和B的最小公倍数。
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
        while (in.hasNext()){
            String s = in.nextLine();
            String[] strs = s.split(" ");
            int a = Integer.parseInt(strs[0]);
            int b = Integer.parseInt(strs[1]);
            System.out.println(a * b / getNum(a, b));
        }
    }
    public static int getNum(int a, int b) {
        return b == 0 ? a : getNum(b, a % b);
    }
}
