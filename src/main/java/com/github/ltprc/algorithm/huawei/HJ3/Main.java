package com.github.ltprc.algorithm.huawei.HJ3;

import java.util.Scanner;

/**
 * 
 * TODO HJ3 �������� �޷�ͨ������
 * 
 * ��Ŀ����
 * ��������ѧУ����һЩͬѧһ����һ���ʾ���飬Ϊ��ʵ��Ŀ͹��ԣ������ü����������N��1��1000֮������������N��1000�������������ظ������֣�ֻ����һ������������ͬ����ȥ������ͬ������Ӧ�Ų�ͬ��ѧ����ѧ�š�Ȼ���ٰ���Щ����С�������򣬰����źõ�˳��ȥ��ͬѧ�����顣����Э��������ɡ�ȥ�ء��롰���򡱵Ĺ���(ͬһ��������������ܻ��ж������ݣ�ϣ���������ȷ����)��
 * ע������������֤�����������ȷ�ԣ�������������֤������������ֹһ�顣
 * ��û���µ�����ʱ��˵�����������
 * 
 * ����������
 * ע�⣺��������ж������ݡ�ÿ�����ݶ��������У���һ����������������ĸ���N����������N����������Ӧ�����������������ʽ�뿴�����"ʾ��"��
 * 
 * ���������
 * ���ض��У������Ľ��
 * 
 * ������ʾ��
 * �ύ��ʱ����Ҫ�����ύimport���
 * ������ȷ��ΪMain�Ҳ�Ҫʹ��public��������η���
 * @author tuoli
 *
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine().toUpperCase();
        int count = Integer.parseInt(s1);
        if (count <= 0) {
            return;
        }
        boolean[] map = new boolean[1000];
        for (int i = 0; i < count; i++) {
            String s2 = in.nextLine();
            int num = Integer.parseInt(s2);
            if (num >= 1 && num <= 1000) {
                map[num - 1] = true;
            }
        }
        for (int i = 0; i < 1000; i++) {
            if (map[i]) {
                output((int)(i + 1));
            }
        }
    }
    public static void output(Object result) {
        System.out.println(result);
    }
}
