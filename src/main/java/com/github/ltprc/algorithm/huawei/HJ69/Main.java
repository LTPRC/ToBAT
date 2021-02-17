package com.github.ltprc.algorithm.huawei.HJ69;

import java.util.Scanner;

/**
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
            int x = Integer.parseInt(in.nextLine());
            int y = Integer.parseInt(in.nextLine());
            int z = Integer.parseInt(in.nextLine());
            int[][] matrix1 = new int[x][y];
            int[][] matrix2 = new int[y][z];
            int[][] matrix3 = new int[x][z];
            String s;
            for (int i = 0; i < x; i++) {
                s = in.nextLine();
                String[] strs = s.split(" ");
                for (int j = 0; j < y; j++) {
                    matrix1[i][j] = Integer.parseInt(strs[j]);
                }
            }
            for (int i = 0; i < y; i++) {
                s = in.nextLine();
                String[] strs = s.split(" ");
                for (int j = 0; j < z; j++) {
                    matrix2[i][j] = Integer.parseInt(strs[j]);
                }
            }
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < z; j++) {
                    int sum = 0;
                    for (int k = 0; k < y; k++) {
                        sum += matrix1[i][k] * matrix2[k][j];
                    }
                    matrix3[i][j] = sum;
                    System.out.print(matrix3[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
