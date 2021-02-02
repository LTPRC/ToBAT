package com.github.ltprc.algorithm.huawei.HJ50;

import java.util.Scanner;

/**
 * TODO 仅通过10%的case
 * 
 * 题目描述
 * 输入一个表达式（用字符串表示），求这个表达式的值。
 * 保证字符串中的有效字符包括[‘0’-‘9’],‘+’,‘-’, ‘*’,‘/’ ,‘(’， ‘)’,‘[’, ‘]’,‘{’ ,‘}’。且表达式一定合法。
 * 
 * 输入描述：
 * 输入一个算术表达式
 * 
 * 输出描述：
 * 得到计算结果
 * 
 * 友情提示：
 * 提交答案时，不要忘记提交import命令。
 * 类名称确保为Main且不要使用public以外的修饰符。
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
