package com.github.ltprc.algorithm.huawei.HJ100;

import java.util.Scanner;

/**
 * ��Ŀ����
 * ����:�Ȳ����� 2��5��8��11��14��������
 * ����:������N >0
 * ���:��Ȳ�����ǰN���
 * ����Ϊ�������룬��ʹ��while(cin>>)����ʽ��ȡ����
 * 
 * ����������
 * ����һ����������
 * 
 * ���������
 * ���һ����Ӻ��������
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
        while (in.hasNext()) {
            String s = in.nextLine();
            int num = Integer.parseInt(s);
            System.out.println((2 + 2 + (num - 1) * 3) * num / 2);
        }
    }
}
