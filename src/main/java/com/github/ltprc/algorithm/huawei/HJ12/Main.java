package com.github.ltprc.algorithm.huawei.HJ12;

import java.util.Scanner;
import java.util.Stack;

/**
 * 
 * ��Ŀ����
 * ����һ��ֻ����Сд��ĸ���ַ�����Ȼ��������ַ�����ת����ַ��������ַ������Ȳ�����1000��
 * 
 * ����������
 * ����һ�У�Ϊһ��ֻ����Сд��ĸ���ַ�����
 * 
 * ���������
 * ������ַ�����ת����ַ�����
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
