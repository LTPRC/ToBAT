package com.github.ltprc.algorithm.huawei.HJ10;

import java.util.Scanner;

/**
 * 
 * ��Ŀ����
 * ��дһ�������������ַ����к��еĲ�ͬ�ַ��ĸ������ַ���ACSII�뷶Χ��(0~127)�����б�ʾ���������������ַ�����ڷ�Χ�ڵĲ���ͳ�ơ������ͬ���ַ�ֻ����һ��
 * ���磬�����ַ���abaca���ԣ���a��b��c���ֲ�ͬ���ַ���������3��
 * 
 * ����������
 * ����һ��û�пո���ַ�����
 * 
 * ���������
 * �����Χ��(0~127)�ַ��ĸ�����
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
            boolean[] map = new boolean[128];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '\n') {
                    break;
                }
                map[c] = true;
            }
            int result = 0;
            for (int i = 0; i < 128; i++) {
                if (map[i]) {
                    result++;
                }
            }
            System.out.println(result);
        }
    }
}
