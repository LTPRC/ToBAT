package com.github.ltprc.algorithm.huawei.HJ106;

import java.util.Scanner;

/**
 * ��Ŀ����
 * ��һ���ַ���str�����ݵߵ��������������str�ĳ��Ȳ�����100���ַ���
 * 
 * ����������
 * ����һ���ַ����������пո�
 * 
 * ���������
 * ���������ַ���
 * 
 * ������ʾ��
 * �ύ��ʱ����Ҫ�����ύimport���
 * ������ȷ��ΪMain�Ҳ�Ҫʹ��public��������η���
 * @author SHY
 *
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        while (!s.isEmpty()) {
            System.out.print(s.charAt(s.length() - 1));
            s = s.substring(0, s.length() - 1);
        }
        System.out.println("");
    }
}
