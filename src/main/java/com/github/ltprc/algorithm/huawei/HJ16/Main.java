package com.github.ltprc.algorithm.huawei.HJ16;

import java.util.Scanner;

/**
 * TODO δ��ɣ�
 * 
 * ��Ŀ����
 * ��ǿ����ܿ��ģ���˾����NԪ�����ս�����ǿ���������ս����ڹ�������������Ʒ��Ϊ���ࣺ�����븽���������Ǵ�����ĳ�������ģ��±����һЩ�����븽�������ӣ�
 * ����  ����
 * ����  ��ӡ����ɨ����
 * ���  ͼ��
 * ����  ̨�ƣ��ľ�
 * ������ ��
 * ���Ҫ�����Ϊ��������Ʒ����������ø���������������ÿ������������ 0 ���� 1 ���� 2 �����������������д������Լ��ĸ�������ǿ����Ķ����ܶ࣬Ϊ�˲�����Ԥ�㣬����ÿ����Ʒ�涨��һ����Ҫ�ȣ���Ϊ 5 �ȣ������� 1 ~ 5 ��ʾ���� 5 ������Ҫ���������������ϲ鵽��ÿ����Ʒ�ļ۸񣨶��� 10 Ԫ��������������ϣ���ڲ����� N Ԫ�����Ե��� N Ԫ����ǰ���£�ʹÿ����Ʒ�ļ۸�����Ҫ�ȵĳ˻����ܺ����
 * ��� j ����Ʒ�ļ۸�Ϊ v[j] ����Ҫ��Ϊ w[j] ����ѡ���� k ����Ʒ���������Ϊ j 1 �� j 2 �������� j k ����������ܺ�Ϊ��
 * v[j 1 ]*w[j 1 ]+v[j 2 ]*w[j 2 ]+ �� +v[j k ]*w[j k ] �������� * Ϊ�˺ţ�
 * ���������ǿ���һ������Ҫ��Ĺ��ﵥ��
 * 
 * ����������
 * ����ĵ� 1 �У�Ϊ��������������һ���ո������N m
 * ������ N �� <32000 ����ʾ��Ǯ���� m �� <60 ��Ϊϣ��������Ʒ�ĸ�������
 * �ӵ� 2 �е��� m+1 �У��� j �и����˱��Ϊ j-1 ����Ʒ�Ļ������ݣ�ÿ���� 3 ���Ǹ����� v p q
 * ������ v ��ʾ����Ʒ�ļ۸� v<10000 ���� p ��ʾ����Ʒ����Ҫ�ȣ� 1 ~ 5 ���� q ��ʾ����Ʒ���������Ǹ�������� q=0 ����ʾ����ƷΪ��������� q>0 ����ʾ����ƷΪ������ q �����������ı�ţ�
 * 
 * ���������
 * ����ļ�ֻ��һ����������Ϊ��������Ǯ������Ʒ�ļ۸�����Ҫ�ȳ˻����ܺ͵����ֵ�� <200000 ����
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
        String[] strs = s.split(" ");
        int amount = Integer.parseInt(strs[0]);
        int count = Integer.parseInt(strs[1]);
        int[][] goods = new int[count][3];//�����۸� �����ļ�ֵ ����ָ��
        for (int i = 0; i < count; i++) {
            s = in.nextLine();
            strs = s.split(" ");
            goods[i][0] = Integer.parseInt(strs[0]);
            goods[i][1] = Integer.parseInt(strs[1]) * goods[i][0];
            goods[i][2] = Integer.parseInt(strs[2]) - 1;
        }
        System.out.println(getValue(goods, amount, count));
    }
    public static int getValue(int[][] goods, int amount, int count) {
        // ʹ�õ��Ļ��� * �������������������� ���������
        int[][] dp = new int[count + 1][amount + 1];
        for (int i = 1; i <= count; i++) {
            for (int j = 1; j <= amount; j++) {
                if (goods[i - 1][2] == -1) {
                    if (goods[i - 1][0] <= j) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - goods[i - 1][0]] + goods[i - 1][1]);
                    }
                } else {
                    if (goods[i - 1][0] + goods[goods[i - 1][2] + 1][0] <= j) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - goods[i - 1][0]] + goods[i - 1][1]);
                    }
                }
            }
        }
        return dp[count][amount];
    }
}
