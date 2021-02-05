package com.github.ltprc.algorithm.huawei.HJ23;

import java.util.Scanner;

/**
 * 题目描述
 * 实现删除字符串中出现次数最少的字符，若多个字符出现次数一样，则都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 * 注意每个输入文件有多组输入，即多个字符串用回车隔开
 * 
 * 输入描述：
 * 字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。
 * 
 * 输出描述：
 * 删除字符串中出现次数最少的字符后的字符串。
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
            int[] map = new int[26];
            for (int i = 0; i < s.length(); i++) {
                map[s.charAt(i) - 'a'] += 1;
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < 26; i++) {
                if (map[i] > 0) {
                    min = Math.min(min, map[i]);
                }
            }
            for (int i = 0; i < 26; i++) {
                if (min == map[i]) {
                    s = s.replace("" + (char)('a' + i), "");
                }
            }
            System.out.println(s);
        }
    }
}
