package com.github.ltprc.algorithm.huawei.HJ1;

import java.util.Scanner;

/**
 * ��Ŀ����
 * �����ַ������һ�����ʵĳ��ȣ������Կո������
 * 
 * ����������
 * ����һ�У�����Ҫ������ַ������ǿգ�����С��5000��
 * 
 * ���������
 * ���һ����������ʾ�����ַ������һ�����ʵĳ��ȡ�
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
        String s = in.nextLine();

        String[] strs = s.split(" ");
        output(strs[strs.length - 1].length());
    }
    public static void output(Object result) {
        System.out.println(result);
    }
}
