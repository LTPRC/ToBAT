package com.github.ltprc.algorithm.huawei.HJ7;

import java.util.Scanner;

/**
 * ��Ŀ����
 * д��һ�����򣬽���һ����������ֵ���������ֵ�Ľ�������ֵ�����С�������ֵ���ڵ���5,����ȡ����С��5��������ȡ����
 * 
 * ����������
 * ����һ����������ֵ
 * 
 * ���������
 * �������ֵ�Ľ�������ֵ
 * 
 * @author tuoli
 *
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        double d = Double.parseDouble(s);
        long result = Math.round(d);

        System.out.println(result);
    }
}
