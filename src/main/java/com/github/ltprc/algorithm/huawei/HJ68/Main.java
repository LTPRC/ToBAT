package com.github.ltprc.algorithm.huawei.HJ68;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * ��Ŀ����
 * ���Һ�����

��Ŀ���������⣨�û����ɼ������У����Ի�óɼ��Ӹߵ��ͻ�ӵ͵��ߵ�����,��ͬ�ɼ�
������¼��������ǰ�Ĺ�����

��ʾ��
jack      70
peter     96
Tom       70
smith     67

�Ӹߵ���  �ɼ�
peter     96
jack      70
Tom       70
smith     67

�ӵ͵���

smith     67

jack      70

Tom       70
peter     96

ע��0����Ӹߵ��ͣ�1����ӵ͵���

���⺬�ж����������ݣ�
 * 
 * ����������
 * ������У�������Ҫ������˵ĸ�����Ȼ��ֱ��������ǵ����ֺͳɼ�����һ���ո����
 * 
 * ���������
 * ����ָ����ʽ������ֺͳɼ������ֺͳɼ�֮����һ���ո����
 * 
 * ������ʾ��
 * �ύ��ʱ����Ҫ�����ύimport���
 * ������ȷ��ΪMain�Ҳ�Ҫʹ��public��������η���
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
