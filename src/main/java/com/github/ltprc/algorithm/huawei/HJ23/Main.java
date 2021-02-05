package com.github.ltprc.algorithm.huawei.HJ23;

import java.util.Scanner;

/**
 * ��Ŀ����
 * ʵ��ɾ���ַ����г��ִ������ٵ��ַ���������ַ����ִ���һ������ɾ�������ɾ����Щ���ʺ���ַ������ַ����������ַ�����ԭ����˳��
 * ע��ÿ�������ļ��ж������룬������ַ����ûس�����
 * 
 * ����������
 * �ַ���ֻ����СдӢ����ĸ, �����ǷǷ����룬������ַ�������С�ڵ���20���ֽڡ�
 * 
 * ���������
 * ɾ���ַ����г��ִ������ٵ��ַ�����ַ�����
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
            int[] map = new int[26];
            for (int i = 0; i < s.length(); i++) {
                map[s.charAt(i) - 'a'] += 1;
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < 26; i++) {
                if (map[i] > 0) {
                    min = Math.min(min, map[i]);
                }
            }
            for (int i = 0; i < 26; i++) {
                if (min == map[i]) {
                    s = s.replace("" + (char)('a' + i), "");
                }
            }
            System.out.println(s);
        }
    }
}
