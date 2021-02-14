package com.github.ltprc.algorithm.huawei.HJ97;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 题目描述
 * 首先输入要输入的整数个数n，然后输入n个整数。输出为n个整数中负数的个数，和所有正整数的平均值，结果保留一位小数。
 * 本题有多组输入用例。
 * 
 * 输入描述：
 * 首先输入一个正整数n，
 * 然后输入n个整数。
 * 
 * 输出描述：
 * 输出负数的个数，和所有正整数的平均值。
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
        while (in.hasNext()) {
            String s = in.nextLine();
            int num = Integer.parseInt(s);
            int count1 = 0, count2 = 0, sum = 0;
            s = in.nextLine();
            String[] strs = s.split(" ");
            for (int i = 0; i < num; i++) {
                int n = Integer.parseInt(strs[i]);
                if (n < 0) {
                    count1++;
                } else if (n > 0) {
                    count2++;
                    sum += n;
                }
            }
            System.out.printf("%d %.1f\n", count1, (double) sum / count2);
        }
    }
}
