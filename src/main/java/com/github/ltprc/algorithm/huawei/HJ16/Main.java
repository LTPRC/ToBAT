package com.github.ltprc.algorithm.huawei.HJ16;

import java.util.Scanner;

/**
 * TODO 未完成！
 * 
 * 题目描述
 * 王强今天很开心，公司发给N元的年终奖。王强决定把年终奖用于购物，他把想买的物品分为两类：主件与附件，附件是从属于某个主件的，下表就是一些主件与附件的例子：
 * 主件  附件
 * 电脑  打印机，扫描仪
 * 书柜  图书
 * 书桌  台灯，文具
 * 工作椅 无
 * 如果要买归类为附件的物品，必须先买该附件所属的主件。每个主件可以有 0 个、 1 个或 2 个附件。附件不再有从属于自己的附件。王强想买的东西很多，为了不超出预算，他把每件物品规定了一个重要度，分为 5 等：用整数 1 ~ 5 表示，第 5 等最重要。他还从因特网上查到了每件物品的价格（都是 10 元的整数倍）。他希望在不超过 N 元（可以等于 N 元）的前提下，使每件物品的价格与重要度的乘积的总和最大。
 * 设第 j 件物品的价格为 v[j] ，重要度为 w[j] ，共选中了 k 件物品，编号依次为 j 1 ， j 2 ，……， j k ，则所求的总和为：
 * v[j 1 ]*w[j 1 ]+v[j 2 ]*w[j 2 ]+ … +v[j k ]*w[j k ] 。（其中 * 为乘号）
 * 请你帮助王强设计一个满足要求的购物单。
 * 
 * 输入描述：
 * 输入的第 1 行，为两个正整数，用一个空格隔开：N m
 * （其中 N （ <32000 ）表示总钱数， m （ <60 ）为希望购买物品的个数。）
 * 从第 2 行到第 m+1 行，第 j 行给出了编号为 j-1 的物品的基本数据，每行有 3 个非负整数 v p q
 * （其中 v 表示该物品的价格（ v<10000 ）， p 表示该物品的重要度（ 1 ~ 5 ）， q 表示该物品是主件还是附件。如果 q=0 ，表示该物品为主件，如果 q>0 ，表示该物品为附件， q 是所属主件的编号）
 * 
 * 输出描述：
 * 输出文件只有一个正整数，为不超过总钱数的物品的价格与重要度乘积的总和的最大值（ <200000 ）。
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
        String s = in.nextLine();
        String[] strs = s.split(" ");
        int amount = Integer.parseInt(strs[0]);
        int count = Integer.parseInt(strs[1]);
        int[][] goods = new int[count][3];//重量价格 核算后的价值 主件指针
        for (int i = 0; i < count; i++) {
            s = in.nextLine();
            strs = s.split(" ");
            goods[i][0] = Integer.parseInt(strs[0]);
            goods[i][1] = Integer.parseInt(strs[1]) * goods[i][0];
            goods[i][2] = Integer.parseInt(strs[2]) - 1;
        }
        System.out.println(getValue(goods, amount, count));
    }
    public static int getValue(int[][] goods, int amount, int count) {
        // 使用到的货物 * 不超过这个重量的情况下 求最大收益
        int[][] dp = new int[count + 1][amount + 1];
        for (int i = 1; i <= count; i++) {
            for (int j = 1; j <= amount; j++) {
                if (goods[i - 1][2] == -1) {
                    if (goods[i - 1][0] <= j) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - goods[i - 1][0]] + goods[i - 1][1]);
                    }
                } else {
                    if (goods[i - 1][0] + goods[goods[i - 1][2] + 1][0] <= j) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - goods[i - 1][0]] + goods[i - 1][1]);
                    }
                }
            }
        }
        return dp[count][amount];
    }
}
