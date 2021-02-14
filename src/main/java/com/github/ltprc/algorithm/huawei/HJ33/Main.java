package com.github.ltprc.algorithm.huawei.HJ33;

import java.util.Scanner;

/**
 * ��Ŀ����
 * ԭ��ip��ַ��ÿ�ο��Կ�����һ��0-255����������ÿ�β�ֳ�һ����������ʽ���������Ȼ��������������ת���
һ����������
������һ��ip��ַΪ10.0.3.193
ÿ������             ���Ӧ�Ķ�������
10                   00001010
0                    00000000
3                    00000011
193                  11000001

���������Ϊ��00001010 00000000 00000011 11000001,ת��Ϊ10���������ǣ�167773121������IP��ַת��������־������ˡ�

���⺬�ж�������������ÿ��������Ҫ�㽫һ��ip��ַת��Ϊ��������һ������ת��Ϊip��ַ��
 * 
 * ����������
 * ���� 
 * 1 ����IP��ַ
 * 2 ����10�����͵�IP��ַ
 * 
 * ���������
 * ���
 * 1 ���ת����10���Ƶ�IP��ַ
 * 2 ���ת�����IP��ַ
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
            /**
             * ip to int
             */
            String s = in.nextLine();
            String[] strs = s.split("\\.");
            int sum = 0;
            for (int i = 0; i < 4; i++) {
                sum = sum << 8;
                sum += Integer.parseInt(strs[i]);
            }
            System.out.println(sum);
            /**
             * int to ip
             */
            s = in.nextLine();
            int num = Integer.parseInt(s);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                sb.insert(0, num % (1 << 8));
                sb.insert(0, ".");
                num = num >>> 8;
            }
            System.out.println(sb.substring(1));
        }
    }
}
