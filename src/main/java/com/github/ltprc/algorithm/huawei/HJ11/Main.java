package com.github.ltprc.algorithm.huawei.HJ11;

import java.util.Scanner;
import java.util.Stack;

/**
 * 
 * 题目描述
 * 输入一个整数，将这个整数以字符串的形式逆序输出
 * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 * 
 * 输入描述：
 * 输入一个int整数
 * 
 * 输出描述：
 * 将这个整数以字符串的形式逆序输出
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
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                stack.push(s.charAt(i));
            }
            while (!stack.empty()) {
                System.out.print(stack.pop());
            }
            System.out.println("");
        }
    }
}
