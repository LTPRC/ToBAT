package com.github.ltprc.algorithm.huawei.HJ15;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * 
 * ��Ŀ����
 * ����һ��int�͵����������������int���������ڴ��д洢ʱ1�ĸ�����
 * 
 * ����������
 * ����һ��������int���ͣ�
 * 
 * ���������
 * �����ת����2���ƺ����1�ĸ���
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
        String s = in.nextLine();
        int num = Integer.parseInt(s);
        int count = 0;
        while (num != 0) {
            count += (num & 1);
            num = num >>> 1;
        }
        System.out.println(count);
    }
}
