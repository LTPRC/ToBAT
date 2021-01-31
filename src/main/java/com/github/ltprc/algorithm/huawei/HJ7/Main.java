package com.github.ltprc.algorithm.huawei.HJ7;

import java.util.Scanner;

/**
 * 题目描述
 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
 * 
 * 输入描述：
 * 输入一个正浮点数值
 * 
 * 输出描述：
 * 输出该数值的近似整数值
 * 
 * @author tuoli
 *
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        double d = Double.parseDouble(s);
        long result = Math.round(d);

        System.out.println(result);
    }
}
