package com.github.ltprc.algorithm.huawei.HJ13;

import java.util.Scanner;

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
            String[] strs = s.split(" ");
            StringBuilder sb = new StringBuilder();
            for (String str : strs) {
                sb.append(flip(str));
                sb.append(" ");
            }
            String result = flip(sb.toString());
            if (!result.isEmpty()) {
                result = result.substring(1);
            }
            System.out.println(result);
        }
    }
    public static String flip(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
