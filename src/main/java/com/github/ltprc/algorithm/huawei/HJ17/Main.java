package com.github.ltprc.algorithm.huawei.HJ17;

import java.util.Scanner;

/**
 * 
 * ��Ŀ����
 * ����һ��������㹤�ߣ� A��ʾ�����ƶ���D��ʾ�����ƶ���W��ʾ�����ƶ���S��ʾ�����ƶ����ӣ�0,0���㿪ʼ�ƶ����������ַ��������ȡһЩ���꣬�����������������������ļ����档
���룺
�Ϸ�����ΪA(����D����W����S) + ���֣���λ���ڣ�
����֮����;�ָ���
�Ƿ��������Ҫ���ж�������AA10;  A1A;  $%$;  YAD; �ȡ�
������һ���򵥵����� �磺
A10;S20;W10;D30;X;A1A;B10A11;;A10;
������̣�
��㣨0,0��
+   A10   =  ��-10,0��
+   S20   =  (-10,-20)
+   W10  =  (-10,-10)
+   D30  =  (20,-10)
+   x    =  ��Ч
+   A1A   =  ��Ч
+   B10A11   =  ��Ч
+  һ���� ��Ӱ��
+   A10  =  (10,-10)
��� ��10�� -10��
ע���봦������������
 * 
 * ����������
 * һ���ַ���
 * 
 * ���������
 * �������꣬�Զ��ŷָ�
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
        int[] pos = new int[] {0, 0};
        while (in.hasNext()) {
            String str = in.nextLine();
            String[] strs = str.split(";");
            for (String s : strs) {
                try {
                    int num = Integer.parseInt(s.substring(1));
                    switch (s.charAt(0)) {
                    case 'W': pos[0] += num; break;
                    case 'A': pos[1] -= num; break;
                    case 'S': pos[0] -= num; break;
                    case 'D': pos[1] += num; break;
                    }
                } catch (Exception e) {
                }
            }
        }
        System.out.println(pos[1] + "," + pos[0]);
    }
}
