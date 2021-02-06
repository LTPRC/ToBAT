package com.github.ltprc.algorithm.huawei.HJ43;

import java.util.Arrays;
import java.util.Scanner;

/**
 * TODO ��ͨ�� 1/10
 * 
 * ��Ŀ����
 * ����һ�����֣���������26���ַ�����ɣ���������ַ����ġ�Ư���ȡ�����������ĸ��Ư���ȡ����ܺ͡�
 * ÿ����ĸ����һ����Ư���ȡ�����Χ��1��26֮�䡣û���κ�������ĸӵ����ͬ�ġ�Ư���ȡ�����ĸ���Դ�Сд��
 * ����������֣�����ÿ�����������ܵġ�Ư���ȡ���
 * 
 * ����������
 * ����N������N������
 * 
 * ���������
 * ÿ�����ƿ��ܵ����Ư���̶�
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
            int count = Integer.parseInt(s);
            for (int i = 0; i < count; i++) {
                int[] map = new int[26];
                s = in.nextLine();
                for (int j = 0; j < s.length(); j++) {
                    map[s.charAt(j) - 'a']++;
                }
                Arrays.sort(map);
                int val = 26;
                int index = 25;
                int result = 0;
                while (index >= 0 && map[index] != 0) {
                    result += (val--) * map[index--];
                }
                System.out.println(result);
            }
        }
    }
}