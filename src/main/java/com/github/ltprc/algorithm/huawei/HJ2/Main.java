package com.github.ltprc.algorithm.huawei.HJ2;

import java.util.Scanner;

/**
 * ��Ŀ����
 * д��һ�����򣬽���һ������ĸ�����ֺͿո���ɵ��ַ�������һ����ĸ��Ȼ����������ַ����и���ĸ�ĳ��ִ����������ִ�Сд��
 * 
 * ����������
 * ��һ������һ������ĸ�������Լ��ո���ɵ��ַ������ڶ�������һ����ĸ��
 * 
 * ���������
 * ��������ַ����к��и��ַ��ĸ�����
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
        String s2 = in.nextLine().toUpperCase();

        int count = 0;
        if (null == s1 || s1.isEmpty() || null == s2 || s2.isEmpty()) {
            output(0);
            return;
        }
        char c = s2.charAt(0);
        for (int i = 0; i < s1.length(); i++) {
            if (c == s1.charAt(i)) {
                count++;
            }
        }
        output(count);
    }
    public static void output(Object result) {
        System.out.println(result);
    }
}
