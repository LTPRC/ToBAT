package com.github.ltprc.algorithm.huawei.HJ9;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 
 * ��Ŀ����
 * ����һ��int�����������մ���������Ķ�˳�򣬷���һ�������ظ����ֵ��µ�������
 * ��֤������������һλ����0��
 * 
 * ����������
 * ����һ��int������
 * 
 * ���������
 * ���մ���������Ķ�˳�򣬷���һ�������ظ����ֵ��µ�����
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
            boolean[] map = new boolean[10];
            StringBuilder sb = new StringBuilder();
            for (int i = s.length() - 1; i >= 0; i--) {
                if (map[s.charAt(i) - '0']) {
                    continue;
                }
                sb.append(s.charAt(i));
                map[s.charAt(i) - '0'] = true;
            }
            System.out.println(sb.toString());
        }
    }
}
