package com.github.ltprc.algorithm.huawei.HJ107;

import java.util.Scanner;

/**
 * TODO ���ְ����޷�ͨ��
 * 
 * ��Ŀ����
 * ����һ�����ֵ�����������ʹ�ÿ⺯����
 * ����һλС����
 * 
 * ����������
 * ����������Ϊdouble���ͣ�һ��ʵ����
 * 
 * ���������
 * ���������������������һλС����
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
        while (in.hasNext()){
            String s = in.nextLine();
            //����1000����ʹ����������
            int num = (int) Math.round(Double.parseDouble(s) * 1000);
            boolean isNeg = false;
            if (num < 0) {
                num = -num;
                isNeg = true;
            }
            int d = 0;
            int diff = Integer.MAX_VALUE;
            while (d * d * d < num) {
                diff = num - d * d * d;
                d += 1;
            }
            String str = String.valueOf(num - d * d * d <= diff ? d : d - 1);
            System.out.println(isNeg ? "-" : "" + str.substring(0, str.length() - 1) + "." + str.charAt(str.length() - 1));
        }
    }
}
