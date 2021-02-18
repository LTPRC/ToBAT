package com.github.ltprc.algorithm.huawei.HJ68;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * 题目描述
 * 查找和排序

题目：输入任意（用户，成绩）序列，可以获得成绩从高到低或从低到高的排列,相同成绩
都按先录入排列在前的规则处理。

例示：
jack      70
peter     96
Tom       70
smith     67

从高到低  成绩
peter     96
jack      70
Tom       70
smith     67

从低到高

smith     67

jack      70

Tom       70
peter     96

注：0代表从高到低，1代表从低到高

本题含有多组输入数据！
 * 
 * 输入描述：
 * 输入多行，先输入要排序的人的个数，然后分别输入他们的名字和成绩，以一个空格隔开
 * 
 * 输出描述：
 * 按照指定方式输出名字和成绩，名字和成绩之间以一个空格隔开
 * 
 * 友情提示：
 * 提交答案时，不要忘记提交import命令。
 * 类名称确保为Main且不要使用public以外的修饰符。
 * @author tuoli
 *
 */
public class Main {
    static class Student {
        int id;
        String name;
        int point;
        public Student(int id, String name, int point) {
            this.id = id;
            this.name = name;
            this.point = point;
        }
    }
    static class Student0 extends Student implements Comparable<Student> {
        public Student0(int id, String name, int point) {
            super(id, name, point);
        }
        @Override
        public int compareTo(Student o) {
            return point == o.point ? id - o.id : o.point - point;
        }
    }
    static class Student1 extends Student implements Comparable<Student> {
        public Student1(int id, String name, int point) {
            super(id, name, point);
        }
        @Override
        public int compareTo(Student o) {
            return point == o.point ? id - o.id : point - o.point;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int count = Integer.parseInt(in.nextLine());
            int type = Integer.parseInt(in.nextLine());
            Queue<Student> q = new PriorityQueue<>();
            for (int i = 0; i < count; i++) {
                String s = in.nextLine();
                String[] strs = s.split(" ");
                if (type == 0) {
                    q.add(new Student0(i, strs[0], Integer.parseInt(strs[1])));
                } else {
                    q.add(new Student1(i, strs[0], Integer.parseInt(strs[1])));
                }
            }
            while (!q.isEmpty()) {
                Student student = q.poll();
                System.out.println(student.name + " " + student.point);
            }
        }
    }
}
