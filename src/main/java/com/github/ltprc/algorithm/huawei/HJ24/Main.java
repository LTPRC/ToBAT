package com.github.ltprc.algorithm.huawei.HJ24;

import java.util.Scanner;

/**
 * TODO ���Բ��� ��Ŀ�ֳ����
 * 
 * ��Ŀ����
 * �������ٳ��ж���λͬѧ��ʹ��ʣ�µ�ͬѧ�ųɺϳ�����
˵����
Nλͬѧվ��һ�ţ�������ʦҪ�����е�(N-K)λͬѧ���У�ʹ��ʣ�µ�Kλͬѧ�ųɺϳ����Ρ�
�ϳ�������ָ������һ�ֶ��Σ���Kλͬѧ���������α��Ϊ1��2����K�����ǵ���߷ֱ�ΪT1��T2������TK��   �����ǵ�����������i��1<=i<=K��ʹ��T1<T2<......<Ti-1<Ti>Ti+1>......>TK��
��������ǣ���֪����Nλͬѧ����ߣ�����������Ҫ��λͬѧ���У�����ʹ��ʣ�µ�ͬѧ�ųɺϳ����Ρ�
 * 
 * ����������
 * ����N
 * 
 * ���������
 * ������Ҫ��λͬѧ����
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
        if (count == 0) {
            System.out.println(0);
        }
        s = in.nextLine();
        String[] strs = s.split(" ");
        /**
         * ˼·�������һ�������Σ��ұ���һ�������Σ��ۼӼ�һ�����������
         */
        int[] rst1 = new int[count];
        int[] rst2 = new int[count];
        for (int i = 0; i < count; i++) {
            rst1[i] = 1;
            for (int j = 0; j < i; j++) {
                if (Integer.parseInt(strs[j]) < Integer.parseInt(strs[i])) {
                    rst1[i] = Math.max(rst1[i], rst1[j] + 1);
                }
            }
        }
        for (int i = count - 1; i >= 0; i--) {
            rst2[i] = 1;
            for (int j = count - 1; j > i; j--) {
                if (Integer.parseInt(strs[j]) < Integer.parseInt(strs[i])) {
                    rst2[i] = Math.max(rst2[i], rst2[j] + 1);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < count; i++) {
            max = Math.max(max, rst1[i] + rst2[i] - 1);
        }
        System.out.println(count - max);
        System.out.println(count - max);
    }
}
