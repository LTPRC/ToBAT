package com.github.ltprc.algorithm.huawei.HJ15;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * 
 * 题目描述
 * 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
 * 
 * 输入描述：
 * 输入一个整数（int类型）
 * 
 * 输出描述：
 * 这个数转换成2进制后，输出1的个数
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
        int num = Integer.parseInt(s);
        int count = 0;
        while (num != 0) {
            count += (num & 1);
            num = num >>> 1;
        }
        System.out.println(count);
    }
}
