package com.github.ltprc.algorithm.huawei.HJ107;

import java.util.Scanner;

/**
 * TODO 部分案例无法通过
 * 
 * 题目描述
 * 计算一个数字的立方根，不使用库函数。
 * 保留一位小数。
 * 
 * 输入描述：
 * 待求解参数，为double类型（一个实数）
 * 
 * 输出描述：
 * 输入参数的立方根。保留一位小数。
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
        while (in.hasNext()){
            String s = in.nextLine();
            //扩大1000倍，使用整数计算
            int num = (int) Math.round(Double.parseDouble(s) * 1000);
            boolean isNeg = false;
            if (num < 0) {
                num = -num;
                isNeg = true;
            }
            int d = 0;
            int diff = Integer.MAX_VALUE;
            while (d * d * d < num) {
                diff = num - d * d * d;
                d += 1;
            }
            String str = String.valueOf(num - d * d * d <= diff ? d : d - 1);
            System.out.println(isNeg ? "-" : "" + str.substring(0, str.length() - 1) + "." + str.charAt(str.length() - 1));
        }
    }
}
