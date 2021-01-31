package com.github.ltprc.algorithm.huawei.HJ10;

import java.util.Scanner;

/**
 * 
 * 题目描述
 * 编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)，换行表示结束符，不算在字符里。不在范围内的不作统计。多个相同的字符只计算一次
 * 例如，对于字符串abaca而言，有a、b、c三种不同的字符，因此输出3。
 * 
 * 输入描述：
 * 输入一行没有空格的字符串。
 * 
 * 输出描述：
 * 输出范围在(0~127)字符的个数。
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
            boolean[] map = new boolean[128];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '\n') {
                    break;
                }
                map[c] = true;
            }
            int result = 0;
            for (int i = 0; i < 128; i++) {
                if (map[i]) {
                    result++;
                }
            }
            System.out.println(result);
        }
    }
}
