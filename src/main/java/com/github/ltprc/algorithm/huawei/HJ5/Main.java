package com.github.ltprc.algorithm.huawei.HJ5;

import java.util.Scanner;

/**
 * ��Ŀ����
 * д��һ�����򣬽���һ��ʮ�����Ƶ������������ֵ��ʮ���Ʊ�ʾ��
 * 
 * ����������
 * ����һ��ʮ�����Ƶ���ֵ�ַ�����ע�⣺һ��������ͬʱ�ж����������ݣ���ο�����https://www.nowcoder.com/discuss/276���������������⡣
 * 
 * ���������
 * �������ֵ��ʮ�����ַ�������ͬ��Ĳ���������\n������
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
            int sum = 0;
            for (int i = 2; i < s.length(); i++) {
                char c = s.charAt(i);
                sum *= 16;
                if (c >= 'A') {
                    sum += c - 'A' + 10;
                } else {
                    sum += c - '0';
                }
            }
            System.out.println(sum);
        }
    }
}
