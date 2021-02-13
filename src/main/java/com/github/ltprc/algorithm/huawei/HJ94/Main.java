package com.github.ltprc.algorithm.huawei.HJ94;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * TODO ��Ŀ������£����԰����г���int��ֵ
 * 
 * ��Ŀ����
 * ��ʵ��һ����Ʊͳ��ϵͳ������յ��ܶ�ͶƱ�������кϷ���Ҳ�в��Ϸ��ģ���ͳ��ÿ����ѡ�˵�Ʊ�������Լ����Ϸ���Ʊ����
 * �����ж����������롣
 * 
 * ����������
 * �����ѡ�˵�����n���ڶ�������n����ѡ�˵����֣���Ϊ��д��ĸ���ַ�����������������ͶƱ�˵�����������������ͶƱ��
 * 
 * ���������
 * ���������˳��ÿ�������ѡ�˵����ֺ͵�Ʊ���������һ��������Ϸ���Ʊ����
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
            s = in.nextLine();
            String[] names = s.split(" ");
            Map<String, Integer> map = new HashMap<>();
            for (String name : names) {
                map.put(name, 0);
            }
            s = in.nextLine();
            int count = Integer.parseInt(s);
            int invalid = 0;
            s = in.nextLine();
            String[] votes = s.split(" ");
            for (int i = 0; i < count; i++) {
                if (map.containsKey(votes[i])) {
                    map.put(votes[i], map.get(votes[i]) + 1);
                } else {
                    invalid++;
                }
            }
            for (int i = 0; i < num; i++) {
                System.out.println(names[i] + " : " + map.get(names[i]));
            }
            System.out.println("Invalid : " + invalid);
        }
    }
}
