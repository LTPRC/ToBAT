package com.github.ltprc.algorithm.huawei.HJ106;

import java.util.Scanner;

/**
 * 题目描述
 * 将一个字符串str的内容颠倒过来，并输出。str的长度不超过100个字符。
 * 
 * 输入描述：
 * 输入一个字符串，可以有空格
 * 
 * 输出描述：
 * 输出逆序的字符串
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
        String s = in.nextLine();
        while (!s.isEmpty()) {
            System.out.print(s.charAt(s.length() - 1));
            s = s.substring(0, s.length() - 1);
        }
        System.out.println("");
    }
}
