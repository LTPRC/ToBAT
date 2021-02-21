package com.github.ltprc.algorithm.huawei.HJ27;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

/**
 * TODO ȥ���ǲ��Եģ��д��޸�
 * 
 * ��Ŀ����
 * ����һ�����ʵġ��ֵܵ��ʡ�Ϊ�������õ�����ĸ˳�򣬶�����ӡ�ɾ�����޸�ԭ�е���ĸ�������ɵĵ��ʡ�
 * �ֵܵ���Ҫ���ԭ���ĵ��ʲ�ͬ�����磺ab��ba���ֵܵ��ʡ�ab��ab�����ֵܵ��ʡ�
 * ���ڸ�����n�����ʣ������ٸ���һ������str������Ѱ��str���ֵܵ�����ֵ����k����Ǹ�������ʲô��
 * ע�⣺�ֵ��п������ظ����ʡ����⺬�ж����������ݡ�
 * 
 * ����������
 * �����뵥�ʵĸ���n��������n�����ʡ�
 * ������һ�����ʣ�Ϊ�����ҵĵ���x
 * �����������k
 * 
 * ���������
 * ������ҵ�x���ֵܵ��ʵĸ���m
 * Ȼ��������ҵ��İ����ֵ�˳�������ĵ�k���ֵܵ��ʣ�û�з��ϵ�k���Ļ����������
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
            String[] strs = s.split(" ");
            int count = Integer.parseInt(strs[0]);
            int k = Integer.parseInt(strs[count + 2]);
            Set<String> set = new HashSet<>();
            for (int i = 1; i <= count; i++) {
                if (check(strs[i], strs[count + 1])) {
                    set.add(strs[i]);
                }
            }
            System.out.println(set.size());
            Queue<String> q = new PriorityQueue<>();
            q.addAll(set);
            String result = q.peek();
            for (int i = 0; i < k - 1; i++) {
                result = q.poll();
            }
            System.out.println(result);
        }
    }
    public static boolean check(String str1, String str2) {
        int[] map = new int[26];
        if (str1.equals(str2)) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            map[str1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < str2.length(); i++) {
            map[str2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (map[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
