package com.github.ltprc.algorithm.huawei.HJ35;

import java.util.Scanner;

/**
 * ��Ŀ����
 * ���ξ�������1��ʼ����Ȼ���������гɵ�һ�������������Ρ�
 * ���磬������5ʱ��Ӧ�������������Ϊ��
 * 1 3 6 10 15
 * 2 5 9 14
 * 4 8 13
 * 7 12
 * 11
 * 
 * ��ע�Ȿ�⺬�ж����������롣
 * 
 * ����������
 * ����������N��N������100��
 * 
 * ���������
 * ���һ��N�е����ξ���
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
            int num = Integer.parseInt(s);
            for (int i = 1, j = 1; j < num + 1; i += j++) {
                for (int k = i, l = j + 1; l <= num + 1; k += l++) {
                    System.out.print(k + " ");
                }
                System.out.println("");
            }
        }
    }
}
