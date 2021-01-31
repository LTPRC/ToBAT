package com.github.ltprc.algorithm.huawei.HJ1;

import java.util.Scanner;

/**
 * 题目描述
 * 计算字符串最后一个单词的长度，单词以空格隔开。
 * 
 * 输入描述：
 * 输入一行，代表要计算的字符串，非空，长度小于5000。
 * 
 * 输出描述：
 * 输出一个整数，表示输入字符串最后一个单词的长度。
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

        String[] strs = s.split(" ");
        output(strs[strs.length - 1].length());
    }
    public static void output(Object result) {
        System.out.println(result);
    }
}
