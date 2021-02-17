package com.github.ltprc.algorithm.huawei.HJ81;

import java.util.Scanner;

/**
 * TODO 牛客网无法通过测试案例
 * wrlpucdezsxphlzrvuguyrwtguvvspncbimokssdzjbms
 * rkjmbnvijlrrrmwfpnufqnmqfgpgythahgfeyfvmvhzczrgltqrwlgp
 * ofecstivslnr
 * eorfrharlvsegeuysdr
 * 
 * 题目描述
 * 判断短字符串中的所有字符是否在长字符串中全部出现。
 * 请注意本题有多组样例输入。
 * 
 * 输入描述：
 * 输入两个字符串。第一个为短字符串，第二个为长字符串。两个字符串均由小写字母组成。
 * 
 * 输出描述：
 * 如果短字符串的所有字符均在长字符串中出现过，则输出true。否则输出false。
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
            String s1 = in.nextLine();
            int bitmap1 = 0;
            for (int i = 0; i < s1.length(); i++) {
                char c = s1.charAt(i);
                bitmap1 |= 2 ^ (c - 'a');
            }
            String s2 = in.nextLine();
            int bitmap2 = 0;
            for (int i = 0; i < s2.length(); i++) {
                char c = s2.charAt(i);
                bitmap2 |= 2 ^ (c - 'a');
            }
            while (bitmap1 != 0 && bitmap2 != 0) {
                if ((bitmap1 & 1) == 1 && (bitmap2 & 1) == 0) {
                    System.out.println(false);
                    return;
                }
                bitmap1 /= 2;
                bitmap2 /= 2;
            }
            System.out.println(true);
        }
    }
}
