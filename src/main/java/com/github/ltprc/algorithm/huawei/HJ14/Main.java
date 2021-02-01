package com.github.ltprc.algorithm.huawei.HJ14;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * 
 * 题目描述
 * 给定n个字符串，请对n个字符串按照字典序排列。
 * 
 * 输入描述：
 * 输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
 * 
 * 输出描述：
 * 数据输出n行，输出结果为按照字典序排列的字符串。
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
        int count = Integer.parseInt(s);
        Queue<String> queue = new PriorityQueue<>();
        for (int i = 0; i < count; i++) {
            s = in.nextLine();
            queue.offer(s);
        }
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
