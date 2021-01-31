package com.github.ltprc.algorithm.huawei.HJ3;

import java.util.Scanner;

/**
 * 
 * TODO HJ3 此题有误 无法通过编译
 * 
 * 题目描述
 * 明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，他先用计算机生成了N个1到1000之间的随机整数（N≤1000），对于其中重复的数字，只保留一个，把其余相同的数去掉，不同的数对应着不同的学生的学号。然后再把这些数从小到大排序，按照排好的顺序去找同学做调查。请你协助明明完成“去重”与“排序”的工作(同一个测试用例里可能会有多组数据，希望大家能正确处理)。
 * 注：测试用例保证输入参数的正确性，答题者无需验证。测试用例不止一组。
 * 当没有新的输入时，说明输入结束。
 * 
 * 输入描述：
 * 注意：输入可能有多组数据。每组数据都包括多行，第一行先输入随机整数的个数N，接下来的N行再输入相应个数的整数。具体格式请看下面的"示例"。
 * 
 * 输出描述：
 * 返回多行，处理后的结果
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
        String s1 = in.nextLine().toUpperCase();
        int count = Integer.parseInt(s1);
        if (count <= 0) {
            return;
        }
        boolean[] map = new boolean[1000];
        for (int i = 0; i < count; i++) {
            String s2 = in.nextLine();
            int num = Integer.parseInt(s2);
            if (num >= 1 && num <= 1000) {
                map[num - 1] = true;
            }
        }
        for (int i = 0; i < 1000; i++) {
            if (map[i]) {
                output((int)(i + 1));
            }
        }
    }
    public static void output(Object result) {
        System.out.println(result);
    }
}
