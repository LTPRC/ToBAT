package com.github.ltprc.algorithm.huawei.HJ4;

import java.util.Scanner;

/**
 * ��Ŀ����
 * ���������ַ������밴����Ϊ8���ÿ���ַ�����������µ��ַ������飻
 * ���Ȳ���8���������ַ������ں��油����0�����ַ���������
 * 
 * ����������
 * ���������ַ���(������,ÿ���ַ�������С��100)
 * 
 * ���������
 * ���������Ϊ8�����ַ�������
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
        while (in.hasNext()) {
            String s = in.nextLine();
            while(s.length() > 8) {
                System.out.println(s.substring(0, 8));
                s = s.substring(8);
            }
            System.out.print(s);
            for (int i = 0; i < 8 - s.length(); i++) {
                System.out.print(0);
            }
            System.out.println("");
        }
    }
}
