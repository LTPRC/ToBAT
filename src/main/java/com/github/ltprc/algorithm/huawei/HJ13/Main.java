package com.github.ltprc.algorithm.huawei.HJ13;

import java.util.Scanner;

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
            String[] strs = s.split(" ");
            StringBuilder sb = new StringBuilder();
            for (String str : strs) {
                sb.append(flip(str));
                sb.append(" ");
            }
            String result = flip(sb.toString());
            if (!result.isEmpty()) {
                result = result.substring(1);
            }
            System.out.println(result);
        }
    }
    public static String flip(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
