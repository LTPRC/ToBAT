package com.github.ltprc.algorithm.huawei.HJ18;

import java.util.Scanner;

/**
 * 
 * ��Ŀ����
 * �����IP��ַ�Ͷ�Ӧ�����룬���з���ʶ��Ҫ����A/B/C/D/E���ַ���࣬���Ϸ��ĵ�ַ�����뵥�����ࡣ
���е�IP��ַ����Ϊ A,B,C,D,E����
A���ַ1.0.0.0~126.255.255.255;
B���ַ128.0.0.0~191.255.255.255;
C���ַ192.0.0.0~223.255.255.255;
D���ַ224.0.0.0~239.255.255.255��
E���ַ240.0.0.0~255.255.255.255
˽��IP��Χ�ǣ�
10.0.0.0��10.255.255.255
172.16.0.0��172.31.255.255
192.168.0.0��192.168.255.255
��������Ϊ��������ǰ����������1��Ȼ��ȫ��0�������磺255.255.255.32����һ���Ƿ������룩
ע���������ȫ��1����ȫ��0��Ϊ�Ƿ�
ע�⣺
1. �����ڡ�0.*.*.*���͡�127.*.*.*����IP��ַ�������������������һ�࣬Ҳ�����ڲ��Ϸ�ip��ַ������ʱ���Ժ���
2. ˽��IP��ַ��A,B,C,D,E���ַ�ǲ���ͻ��
 * 
 * ����������
 * �����ַ�����ÿ��һ��IP��ַ�����룬��~������
 * 
 * ���������
 * ͳ��A��B��C��D��E������IP��ַ��������롢˽��IP�ĸ�����֮���Կո������
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
        int[] result = new int[7];
        while (in.hasNext()){
            String str = in.nextLine();
            checkIp(str, result);
        }
        for (int i = 0; i < 7; i++) {
            System.out.print(result[i]);
            if (i != 6) {
                System.out.print(" ");
            }
        }
    }
    public static void checkIp(String str, int[] result) {
        /**
         * TODO
         */
    }
}
