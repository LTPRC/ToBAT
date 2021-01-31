package com.github.ltprc.algorithm.huawei.HJ8;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 
 * 题目描述
 * 数据表记录包含表索引和数值（int范围的正整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
 * 
 * 输入描述：
 * 先输入键值对的个数
 * 然后输入成对的index和value值，以空格隔开
 * 
 * 输出描述：
 * 输出合并后的键值对（多行）
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
            int count = Integer.parseInt(s);
            Map<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < count; i++) {
                s = in.nextLine();
                String[] strs = s.split(" ");
                int key = Integer.parseInt(strs[0]);
                int value = Integer.parseInt(strs[1]);
                if (map.containsKey(key)) {
                    value += map.get(key);
                }
                map.put(key,  value);
            }
            for (Entry<Integer, Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }
}
