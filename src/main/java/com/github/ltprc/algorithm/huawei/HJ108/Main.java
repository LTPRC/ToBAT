package com.github.ltprc.algorithm.huawei.HJ108;

import java.util.Scanner;

/**
 * ��Ŀ����
 * ������A��������B ����С��������ָ �ܱ�A��B��������С��������ֵ�����һ���㷨��������A��B����С��������
 * 
 * ����������
 * ��������������A��B��
 * 
 * ���������
 * ���A��B����С��������
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
        while (in.hasNext()){
            String s = in.nextLine();
            String[] strs = s.split(" ");
            int a = Integer.parseInt(strs[0]);
            int b = Integer.parseInt(strs[1]);
            System.out.println(a * b / getNum(a, b));
        }
    }
    public static int getNum(int a, int b) {
        return b == 0 ? a : getNum(b, a % b);
    }
}
