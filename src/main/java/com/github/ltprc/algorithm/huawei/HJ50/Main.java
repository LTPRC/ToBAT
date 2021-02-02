package com.github.ltprc.algorithm.huawei.HJ50;

import java.util.Scanner;

/**
 * TODO ��ͨ��10%��case
 * 
 * ��Ŀ����
 * ����һ�����ʽ�����ַ�����ʾ������������ʽ��ֵ��
 * ��֤�ַ����е���Ч�ַ�����[��0��-��9��],��+��,��-��, ��*��,��/�� ,��(���� ��)��,��[��, ��]��,��{�� ,��}�����ұ��ʽһ���Ϸ���
 * 
 * ����������
 * ����һ���������ʽ
 * 
 * ���������
 * �õ�������
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
        int[] result = new int[7];
        while (in.hasNext()){
            String s = in.nextLine();
            System.out.println(processParentheses(s));
        }
    }
    public static int processParentheses(String s) {
        int from = s.indexOf('(');
        int to = s.indexOf(')');
        if (from != -1 && to != -1) {
            return processParentheses(s.substring(0, from) 
                    + String.valueOf(processAdd(s.substring(from + 1, to)))
                    + s.substring(to + 1));
        } else {
            return processBracket(s);
        }
    }
    public static int processBracket(String s) {
        int from = s.indexOf('[');
        int to = s.indexOf(']');
        if (from != -1 && to != -1) {
            return processBracket(s.substring(0, from) 
                    + String.valueOf(processAdd(s.substring(from + 1, to)))
                    + s.substring(to + 1));
        } else {
            return processBrace(s);
        }
    }
    public static int processBrace(String s) {
        int from = s.indexOf('{');
        int to = s.indexOf('}');
        if (from != -1 && to != -1) {
            return processBrace(s.substring(0, from) 
                    + String.valueOf(processAdd(s.substring(from + 1, to)))
                    + s.substring(to + 1));
        } else {
            return processAdd(s);
        }
    }
    public static int processAdd(String s) {
        String[] segments = s.split("\\+");
        int sum = 0;
        for (String segment : segments) {
            sum += processSubstract(segment);
        }
        return sum;
    }
    public static int processSubstract(String s) {
        String[] segments = s.split("-");
        int sum = segments[0].isEmpty() ? 0 : processMultiply(segments[0]);
        for (int i = 1; i < segments.length; i++) {
            sum -= processMultiply(segments[i]);
        }
        return sum;
    }
    public static int processMultiply(String s) {
        String[] segments = s.split("\\*");
        int result = 1;
        for (String segment : segments) {
            result *= processDivide(segment);
        }
        return result;
    }
    public static int processDivide(String s) {
        String[] segments = s.split("/");
        int result = Integer.parseInt(segments[0]) * Integer.parseInt(segments[0]);
        for (String segment : segments) {
            result /= Integer.parseInt(segment);
        }
        return result;
    }
}
