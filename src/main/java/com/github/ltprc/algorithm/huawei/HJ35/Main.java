package com.github.ltprc.algorithm.huawei.HJ35;

import java.util.Scanner;

/**
 * 题目描述
 * 蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。
 * 例如，当输入5时，应该输出的三角形为：
 * 1 3 6 10 15
 * 2 5 9 14
 * 4 8 13
 * 7 12
 * 11
 * 
 * 请注意本题含有多组样例输入。
 * 
 * 输入描述：
 * 输入正整数N（N不大于100）
 * 
 * 输出描述：
 * 输出一个N行的蛇形矩阵。
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
            int num = Integer.parseInt(s);
            for (int i = 1, j = 1; j < num + 1; i += j++) {
                for (int k = i, l = j + 1; l <= num + 1; k += l++) {
                    System.out.print(k + " ");
                }
                System.out.println("");
            }
        }
    }
}
