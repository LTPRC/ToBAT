package com.github.ltprc.algorithm.huawei.HJ8;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 
 * ��Ŀ����
 * ���ݱ��¼��������������ֵ��int��Χ��������������Ա�������ͬ�ļ�¼���кϲ���������ͬ��������ֵ����������㣬�������keyֵ������������
 * 
 * ����������
 * �������ֵ�Եĸ���
 * Ȼ������ɶԵ�index��valueֵ���Կո����
 * 
 * ���������
 * ����ϲ���ļ�ֵ�ԣ����У�
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
            int count = Integer.parseInt(s);
            Map<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < count; i++) {
                s = in.nextLine();
                String[] strs = s.split(" ");
                int key = Integer.parseInt(strs[0]);
                int value = Integer.parseInt(strs[1]);
                if (map.containsKey(key)) {
                    value += map.get(key);
                }
                map.put(key,  value);
            }
            for (Entry<Integer, Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }
}
