package com.github.ltprc.algorithm.huawei.HJ43;

import java.util.Arrays;
import java.util.Scanner;

/**
 * TODO 仅通过 1/10
 * 
 * 题目描述
 * 给出一个名字，该名字有26个字符串组成，定义这个字符串的“漂亮度”是其所有字母“漂亮度”的总和。
 * 每个字母都有一个“漂亮度”，范围在1到26之间。没有任何两个字母拥有相同的“漂亮度”。字母忽略大小写。
 * 给出多个名字，计算每个名字最大可能的“漂亮度”。
 * 
 * 输入描述：
 * 整数N，后续N个名字
 * 
 * 输出描述：
 * 每个名称可能的最大漂亮程度
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
            int count = Integer.parseInt(s);
            for (int i = 0; i < count; i++) {
                int[] map = new int[26];
                s = in.nextLine();
                for (int j = 0; j < s.length(); j++) {
                    map[s.charAt(j) - 'a']++;
                }
                Arrays.sort(map);
                int val = 26;
                int index = 25;
                int result = 0;
                while (index >= 0 && map[index] != 0) {
                    result += (val--) * map[index--];
                }
                System.out.println(result);
            }
        }
    }
}