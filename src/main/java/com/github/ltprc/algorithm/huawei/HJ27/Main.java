package com.github.ltprc.algorithm.huawei.HJ27;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

/**
 * TODO 去重是不对的，有待修改
 * 
 * 题目描述
 * 定义一个单词的“兄弟单词”为：交换该单词字母顺序，而不添加、删除、修改原有的字母就能生成的单词。
 * 兄弟单词要求和原来的单词不同。例如：ab和ba是兄弟单词。ab和ab则不是兄弟单词。
 * 现在给定你n个单词，另外再给你一个单词str，让你寻找str的兄弟单词里，字典序第k大的那个单词是什么？
 * 注意：字典中可能有重复单词。本题含有多组输入数据。
 * 
 * 输入描述：
 * 先输入单词的个数n，再输入n个单词。
 * 再输入一个单词，为待查找的单词x
 * 最后输入数字k
 * 
 * 输出描述：
 * 输出查找到x的兄弟单词的个数m
 * 然后输出查找到的按照字典顺序排序后的第k个兄弟单词，没有符合第k个的话则不用输出。
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
            String[] strs = s.split(" ");
            int count = Integer.parseInt(strs[0]);
            int k = Integer.parseInt(strs[count + 2]);
            Set<String> set = new HashSet<>();
            for (int i = 1; i <= count; i++) {
                if (check(strs[i], strs[count + 1])) {
                    set.add(strs[i]);
                }
            }
            System.out.println(set.size());
            Queue<String> q = new PriorityQueue<>();
            q.addAll(set);
            String result = q.peek();
            for (int i = 0; i < k - 1; i++) {
                result = q.poll();
            }
            System.out.println(result);
        }
    }
    public static boolean check(String str1, String str2) {
        int[] map = new int[26];
        if (str1.equals(str2)) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            map[str1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < str2.length(); i++) {
            map[str2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (map[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
