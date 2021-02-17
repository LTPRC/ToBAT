package com.github.ltprc.algorithm.huawei.HJ81;

import java.util.Scanner;

/**
 * TODO ţ�����޷�ͨ�����԰���
 * wrlpucdezsxphlzrvuguyrwtguvvspncbimokssdzjbms
 * rkjmbnvijlrrrmwfpnufqnmqfgpgythahgfeyfvmvhzczrgltqrwlgp
 * ofecstivslnr
 * eorfrharlvsegeuysdr
 * 
 * ��Ŀ����
 * �ж϶��ַ����е������ַ��Ƿ��ڳ��ַ�����ȫ�����֡�
 * ��ע�Ȿ���ж����������롣
 * 
 * ����������
 * ���������ַ�������һ��Ϊ���ַ������ڶ���Ϊ���ַ����������ַ�������Сд��ĸ��ɡ�
 * 
 * ���������
 * ������ַ����������ַ����ڳ��ַ����г��ֹ��������true���������false��
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
            String s1 = in.nextLine();
            int bitmap1 = 0;
            for (int i = 0; i < s1.length(); i++) {
                char c = s1.charAt(i);
                bitmap1 |= 2 ^ (c - 'a');
            }
            String s2 = in.nextLine();
            int bitmap2 = 0;
            for (int i = 0; i < s2.length(); i++) {
                char c = s2.charAt(i);
                bitmap2 |= 2 ^ (c - 'a');
            }
            while (bitmap1 != 0 && bitmap2 != 0) {
                if ((bitmap1 & 1) == 1 && (bitmap2 & 1) == 0) {
                    System.out.println(false);
                    return;
                }
                bitmap1 /= 2;
                bitmap2 /= 2;
            }
            System.out.println(true);
        }
    }
}
