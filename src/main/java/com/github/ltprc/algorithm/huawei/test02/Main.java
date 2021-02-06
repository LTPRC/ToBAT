package com.github.ltprc.algorithm.huawei.test02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * TODO 仅通过85%测试案例
 * 
 * 题目描述
 * ...
 * 
 * 输入描述：
 * ...
 * 
 * 输出描述：
 * ...
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
        while (in.hasNext()) {
            List<String> list = new ArrayList<>();
            String result = "";
            String s = in.nextLine();
            String[] str1s = s.split("\\+");
            for (int i = 0; i < str1s.length; i++) {
                String str1 = i != 0 ? "+" + str1s[i] : str1s[i];
                String[] str2s = str1.split("\\-");
                for (int j = 0; j < str2s.length; j++) {
                    String str2 = j != 0 ? "-" + str2s[j] : str2s[j];
                    list.add(str2);
                }
            }
            for (String str : list) {
                int begin = -1;
                for (int i = 0; i < str.length(); i++) {
                    if (begin == -1) {
                        if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '.' || (str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
                            begin = i;
                        }
                    } else {
                        if (!(str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '.' || (str.charAt(i) >= '0' && str.charAt(i) <= '9'))) {
                            String checkRst = check(str.substring(begin, i));
                            if (checkRst.length() >= result.length()) {
                                result = checkRst;
                            }
                            begin = -1;
                        }
                    }
                }
                if (begin != -1) {
                    String checkRst = check(str.substring(begin));
                    if (checkRst.length() >= result.length()) {
                        result = checkRst;
                    }
                }
            }
            System.out.println(result);
        }
    }
    public static String check(String s) {
        while (!s.isEmpty() && s.indexOf(".") == 0) {
            s = s.substring(1);
        }
        while (!s.isEmpty() && s.indexOf("+.") == 0) {
            s = s.substring(2);
        }
        while (!s.isEmpty() && s.indexOf("-.") == 0) {
            s = s.substring(2);
        }
        while (!s.isEmpty() && s.charAt(s.length() - 1) == '.') {
            s = s.substring(0, s.length() - 1);
        }
        if (s.isEmpty()) {
            return s;
        }
        String[] strs = s.split("\\.");
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() >= result.length()) {
                result = strs[i];
            }
            if (!strs[i - 1].isEmpty() && !strs[i].isEmpty()) {
                String tmp = strs[i - 1] + "." + strs[i];
                if (tmp.length() >= result.length()) {
                    result = tmp;
                }
            }
        }
        return result;
    }
}
