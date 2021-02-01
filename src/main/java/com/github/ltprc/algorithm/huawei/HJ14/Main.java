package com.github.ltprc.algorithm.huawei.HJ14;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * 
 * ��Ŀ����
 * ����n���ַ��������n���ַ��������ֵ������С�
 * 
 * ����������
 * �����һ��Ϊһ��������n(1��n��1000),����n��Ϊn���ַ���(�ַ������ȡ�100),�ַ�����ֻ���д�Сд��ĸ��
 * 
 * ���������
 * �������n�У�������Ϊ�����ֵ������е��ַ�����
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
        int count = Integer.parseInt(s);
        Queue<String> queue = new PriorityQueue<>();
        for (int i = 0; i < count; i++) {
            s = in.nextLine();
            queue.offer(s);
        }
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
