package com.github.ltprc.algorithm.huawei.HJ12;

import java.util.Scanner;
import java.util.Stack;

/**
 * 
 * 题目描述
 * 接受一个只包含小写字母的字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
 * 
 * 输入描述：
 * 输入一行，为一个只包含小写字母的字符串。
 * 
 * 输出描述：
 * 输出该字符串反转后的字符串。
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
