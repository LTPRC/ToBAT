package com.github.ltprc.algorithm.huawei.HJ9;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 
 * 题目描述
 * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * 保证输入的整数最后一位不是0。
 * 
 * 输入描述：
 * 输入一个int型整数
 * 
 * 输出描述：
 * 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
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
            boolean[] map = new boolean[10];
            StringBuilder sb = new StringBuilder();
            for (int i = s.length() - 1; i >= 0; i--) {
                if (map[s.charAt(i) - '0']) {
                    continue;
                }
                sb.append(s.charAt(i));
                map[s.charAt(i) - '0'] = true;
            }
            System.out.println(sb.toString());
        }
    }
}
