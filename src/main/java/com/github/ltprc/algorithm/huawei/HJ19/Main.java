package com.github.ltprc.algorithm.huawei.HJ19;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/**
 * TODO ��ͨ�� 1/10
 * 
 * ��Ŀ����
 * ����һ���򵥴����¼����Сģ�飬�ܹ���¼����Ĵ������ڵ��ļ����ƺ��кš�
����
1�� ��¼���8�������¼��ѭ����¼�����ֻ����������ֵİ��������¼������ͬ�Ĵ����¼ֻ��¼һ�������Ǵ���������ӡ����һ��б�ܺ���Ĵ���׺���Ĳ��֣��������16λ�����к���ȫƥ��ļ�¼�������ǡ���ͬ���Ĵ����¼��
2�� ����16���ַ����ļ����ƣ�ֻ��¼�ļ��������Ч16���ַ���
3�� ������ļ����ܴ�·������¼�ļ����Ʋ��ܴ�·����
4��ѭ����¼ʱ��ֻ�Ե�һ�γ��ֵ�˳��Ϊ׼�������ظ��Ĳ���������ĳ���ʱ�䣬���Ե�һ��Ϊ׼
 * 
 * ����������
 * ÿ��ֻ����һ������������һ��������������һ�л�����ַ�����ÿ�а�����·���ļ����ƣ��кţ��Կո������
 * 
 * ���������
 * �����еļ�¼ͳ�Ʋ�������������ʽ���ļ��� �������� ��Ŀ��һ���ո�������磺
ʾ��1
����
D:\zwtymj\xccb\ljj\cqzlyaszjvlsjmkwoqijggmybr 645
E:\je\rzuwnjvnuz 633
C:\km\tgjwpb\gy\atl 637
F:\weioj\hadd\connsh\rwyfvzsopsuiqjnr 647
E:\ns\mfwj\wqkoki\eez 648
D:\cfmwafhhgeyawnool 649
E:\czt\opwip\osnll\c 637
G:\nt\f 633
F:\fop\ywzqaop 631
F:\yay\jc\ywzqaop 631
���
rzuwnjvnuz 633 1
atl 637 1
rwyfvzsopsuiqjnr 647 1
eez 648 1
fmwafhhgeyawnool 649 1
c 637 1
f 633 1
ywzqaop 631 2
 * 
 * ������ʾ��
 * �ύ��ʱ����Ҫ�����ύimport���
 * ������ȷ��ΪMain�Ҳ�Ҫʹ��public��������η���
 * @author SHY
 *
 */
public class Main {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String name = in.nextLine();
            String[] strs = name.split("\\\\");
            name = strs[strs.length - 1];
            if (map.containsKey(name)) {
                map.put(name, map.get(name) + 1);
            } else {
                q.add(name);
                map.put(name, 1);
            }
        }
        while (!q.isEmpty()) {
            String name = q.poll();
            int count = map.get(name);
            if (name.indexOf(" ") > 16) {
                name = name.substring(name.indexOf(" ") - 16);
            }
            System.out.println(name + " " + count);
        }
    }
}
