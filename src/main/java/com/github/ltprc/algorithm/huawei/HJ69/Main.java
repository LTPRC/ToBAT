package com.github.ltprc.algorithm.huawei.HJ69;

import java.util.Scanner;

/**
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
            int x = Integer.parseInt(in.nextLine());
            int y = Integer.parseInt(in.nextLine());
            int z = Integer.parseInt(in.nextLine());
            int[][] matrix1 = new int[x][y];
            int[][] matrix2 = new int[y][z];
            int[][] matrix3 = new int[x][z];
            String s;
            for (int i = 0; i < x; i++) {
                s = in.nextLine();
                String[] strs = s.split(" ");
                for (int j = 0; j < y; j++) {
                    matrix1[i][j] = Integer.parseInt(strs[j]);
                }
            }
            for (int i = 0; i < y; i++) {
                s = in.nextLine();
                String[] strs = s.split(" ");
                for (int j = 0; j < z; j++) {
                    matrix2[i][j] = Integer.parseInt(strs[j]);
                }
            }
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < z; j++) {
                    int sum = 0;
                    for (int k = 0; k < y; k++) {
                        sum += matrix1[i][k] * matrix2[k][j];
                    }
                    matrix3[i][j] = sum;
                    System.out.print(matrix3[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
