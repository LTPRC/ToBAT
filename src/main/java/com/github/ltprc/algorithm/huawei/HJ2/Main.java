package com.github.ltprc.algorithm.huawei.HJ2;

import java.util.Scanner;

/**
 * 题目描述
 * 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字母，然后输出输入字符串中该字母的出现次数。不区分大小写。
 * 
 * 输入描述：
 * 第一行输入一个由字母和数字以及空格组成的字符串，第二行输入一个字母。
 * 
 * 输出描述：
 * 输出输入字符串中含有该字符的个数。
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
        String s2 = in.nextLine().toUpperCase();

        int count = 0;
        if (null == s1 || s1.isEmpty() || null == s2 || s2.isEmpty()) {
            output(0);
            return;
        }
        char c = s2.charAt(0);
        for (int i = 0; i < s1.length(); i++) {
            if (c == s1.charAt(i)) {
                count++;
            }
        }
        output(count);
    }
    public static void output(Object result) {
        System.out.println(result);
    }
}
