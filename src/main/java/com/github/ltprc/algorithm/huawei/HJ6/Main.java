package com.github.ltprc.algorithm.huawei.HJ6;

import java.util.Scanner;

/**
 * 
 * TODO HJ6 �������� �޷�ͨ������
 * 
 * ��Ŀ����
 * ����:����һ�������������մ�С�����˳������������������ӣ��ظ���ҲҪ�о٣�����180��������Ϊ2 2 3 3 5 ��
 * ���һ��������ҲҪ�пո�
 * 
 * ����������
 * ����һ��long������
 * 
 * ���������
 * ���մ�С�����˳����������������������ӣ��Կո���������һ��������ҲҪ�пո�
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
        while (in.hasNextLong()) {
            long num = in.nextLong();
            for (long i = 2; i <= num; i++) {
                while (num % i == 0) {
                    System.out.print(i + " ");
                    num /= i;
                }
                if (num == 1) {
                    break;
                }
            }
            System.out.println("");
        }
    }
}
