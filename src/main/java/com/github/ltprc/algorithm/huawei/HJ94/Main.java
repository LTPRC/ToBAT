package com.github.ltprc.algorithm.huawei.HJ94;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * TODO 题目不讲武德，测试案例有超过int的值
 * 
 * 题目描述
 * 请实现一个计票统计系统。你会收到很多投票，其中有合法的也有不合法的，请统计每个候选人得票的数量以及不合法的票数。
 * 本题有多组样例输入。
 * 
 * 输入描述：
 * 输入候选人的人数n，第二行输入n个候选人的名字（均为大写字母的字符串），第三行输入投票人的人数，第四行输入投票。
 * 
 * 输出描述：
 * 按照输入的顺序，每行输出候选人的名字和得票数量，最后一行输出不合法的票数。
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
            s = in.nextLine();
            String[] names = s.split(" ");
            Map<String, Integer> map = new HashMap<>();
            for (String name : names) {
                map.put(name, 0);
            }
            s = in.nextLine();
            int count = Integer.parseInt(s);
            int invalid = 0;
            s = in.nextLine();
            String[] votes = s.split(" ");
            for (int i = 0; i < count; i++) {
                if (map.containsKey(votes[i])) {
                    map.put(votes[i], map.get(votes[i]) + 1);
                } else {
                    invalid++;
                }
            }
            for (int i = 0; i < num; i++) {
                System.out.println(names[i] + " : " + map.get(names[i]));
            }
            System.out.println("Invalid : " + invalid);
        }
    }
}
