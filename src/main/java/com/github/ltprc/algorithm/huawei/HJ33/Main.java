package com.github.ltprc.algorithm.huawei.HJ33;

import java.util.Scanner;

/**
 * 题目描述
 * 原理：ip地址的每段可以看成是一个0-255的整数，把每段拆分成一个二进制形式组合起来，然后把这个二进制数转变成
一个长整数。
举例：一个ip地址为10.0.3.193
每段数字             相对应的二进制数
10                   00001010
0                    00000000
3                    00000011
193                  11000001

组合起来即为：00001010 00000000 00000011 11000001,转换为10进制数就是：167773121，即该IP地址转换后的数字就是它了。

本题含有多组输入用例，每组用例需要你将一个ip地址转换为整数、将一个整数转换为ip地址。
 * 
 * 输入描述：
 * 输入 
 * 1 输入IP地址
 * 2 输入10进制型的IP地址
 * 
 * 输出描述：
 * 输出
 * 1 输出转换成10进制的IP地址
 * 2 输出转换后的IP地址
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
            /**
             * ip to int
             */
            String s = in.nextLine();
            String[] strs = s.split("\\.");
            int sum = 0;
            for (int i = 0; i < 4; i++) {
                sum = sum << 8;
                sum += Integer.parseInt(strs[i]);
            }
            System.out.println(sum);
            /**
             * int to ip
             */
            s = in.nextLine();
            int num = Integer.parseInt(s);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                sb.insert(0, num % (1 << 8));
                sb.insert(0, ".");
                num = num >>> 8;
            }
            System.out.println(sb.substring(1));
        }
    }
}
