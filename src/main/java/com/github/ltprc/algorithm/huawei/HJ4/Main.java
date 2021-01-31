package com.github.ltprc.algorithm.huawei.HJ4;

import java.util.Scanner;

/**
 * 题目描述
 * 连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 * 长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * 
 * 输入描述：
 * 连续输入字符串(输入多次,每个字符串长度小于100)
 * 
 * 输出描述：
 * 输出到长度为8的新字符串数组
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
            while(s.length() > 8) {
                System.out.println(s.substring(0, 8));
                s = s.substring(8);
            }
            System.out.print(s);
            for (int i = 0; i < 8 - s.length(); i++) {
                System.out.print(0);
            }
            System.out.println("");
        }
    }
}
