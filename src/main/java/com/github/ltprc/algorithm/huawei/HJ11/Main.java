package com.github.ltprc.algorithm.huawei.HJ11;

import java.util.Scanner;
import java.util.Stack;

/**
 * 
 * ��Ŀ����
 * ����һ��������������������ַ�������ʽ�������
 * ���򲻿��Ǹ���������������ֺ���0����������ʽҲ����0��������Ϊ100�������Ϊ001
 * 
 * ����������
 * ����һ��int����
 * 
 * ���������
 * ������������ַ�������ʽ�������
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
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                stack.push(s.charAt(i));
            }
            while (!stack.empty()) {
                System.out.print(stack.pop());
            }
            System.out.println("");
        }
    }
}
