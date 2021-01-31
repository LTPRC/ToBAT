package com.github.ltprc.algorithm.huawei.HJ5;

import java.util.Scanner;

/**
 * 题目描述
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
 * 
 * 输入描述：
 * 输入一个十六进制的数值字符串。注意：一个用例会同时有多组输入数据，请参考帖子https://www.nowcoder.com/discuss/276处理多组输入的问题。
 * 
 * 输出描述：
 * 输出该数值的十进制字符串。不同组的测试用例用\n隔开。
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
            int sum = 0;
            for (int i = 2; i < s.length(); i++) {
                char c = s.charAt(i);
                sum *= 16;
                if (c >= 'A') {
                    sum += c - 'A' + 10;
                } else {
                    sum += c - '0';
                }
            }
            System.out.println(sum);
        }
    }
}
