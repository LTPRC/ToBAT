package com.github.ltprc.algorithm.huawei.HJ100;

import java.util.Scanner;

/**
 * 题目描述
 * 功能:等差数列 2，5，8，11，14。。。。
 * 输入:正整数N >0
 * 输出:求等差数列前N项和
 * 本题为多组输入，请使用while(cin>>)等形式读取数据
 * 
 * 输入描述：
 * 输入一个正整数。
 * 
 * 输出描述：
 * 输出一个相加后的整数。
 * 
 * 友情提示：
 * 提交答案时，不要忘记提交import命令。
 * 类名称确保为Main且不要使用public以外的修饰符。
 * @author SHY
 *
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.nextLine();
            int num = Integer.parseInt(s);
            System.out.println((2 + 2 + (num - 1) * 3) * num / 2);
        }
    }
}
