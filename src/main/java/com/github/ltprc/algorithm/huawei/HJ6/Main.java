package com.github.ltprc.algorithm.huawei.HJ6;

import java.util.Scanner;

/**
 * 
 * TODO HJ6 此题有误 无法通过编译
 * 
 * 题目描述
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
 * 最后一个数后面也要有空格
 * 
 * 输入描述：
 * 输入一个long型整数
 * 
 * 输出描述：
 * 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。最后一个数后面也要有空格。
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
        while (in.hasNextLong()) {
            long num = in.nextLong();
            for (long i = 2; i <= num; i++) {
                while (num % i == 0) {
                    System.out.print(i + " ");
                    num /= i;
                }
                if (num == 1) {
                    break;
                }
            }
            System.out.println("");
        }
    }
}
