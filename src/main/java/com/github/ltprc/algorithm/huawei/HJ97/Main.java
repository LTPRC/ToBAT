package com.github.ltprc.algorithm.huawei.HJ97;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * ��Ŀ����
 * ��������Ҫ�������������n��Ȼ������n�����������Ϊn�������и����ĸ�������������������ƽ��ֵ���������һλС����
 * �����ж�������������
 * 
 * ����������
 * ��������һ��������n��
 * Ȼ������n��������
 * 
 * ���������
 * ��������ĸ�������������������ƽ��ֵ��
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
            int num = Integer.parseInt(s);
            int count1 = 0, count2 = 0, sum = 0;
            s = in.nextLine();
            String[] strs = s.split(" ");
            for (int i = 0; i < num; i++) {
                int n = Integer.parseInt(strs[i]);
                if (n < 0) {
                    count1++;
                } else if (n > 0) {
                    count2++;
                    sum += n;
                }
            }
            System.out.printf("%d %.1f\n", count1, (double) sum / count2);
        }
    }
}
