package com.github.ltprc.algorithm.huawei.HJ21;

import java.util.Scanner;

/**
 * 题目描述
 * 密码是我们生活中非常重要的东东，我们的那么一点不能说的秘密就全靠它了。哇哈哈. 接下来渊子要在密码之上再加一套密码，虽然简单但也安全。
 * 假设渊子原来一个BBS上的密码为zvbo9441987,为了方便记忆，他通过一种算法把这个密码变换成YUANzhi1987，这个密码是他的名字和出生年份，怎么忘都忘不了，而且可以明目张胆地放在显眼的地方而不被别人知道真正的密码。
 * 他是这么变换的，大家都知道手机上的字母： 1--1， abc--2, def--3, ghi--4, jkl--5, mno--6, pqrs--7, tuv--8 wxyz--9, 0--0,就这么简单，渊子把密码中出现的小写字母都变成对应的数字，数字和其他的符号都不做变换，
 * 声明：密码中没有空格，而密码中出现的大写字母则变成小写之后往后移一位，如：X，先变成小写，再往后移一位，不就是y了嘛，简单吧。记住，z往后移是a哦。
 * 
 * 输入描述：
 * 输入包括多个测试数据。输入是一个明文，密码长度不超过100个字符，输入直到文件结尾
 * 
 * 输出描述：
 * 输出渊子真正的密文
 * 
 * 友情提示：
 * 提交答案时，不要忘记提交import命令。
 * 类名称确保为Main且不要使用public以外的修饰符。
 * @author SHY
 *
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        if (null == s || s.isEmpty()) {
            output(s);
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                switch (c) {
                case 'a':sb.append('2');break;
                case 'b':sb.append('2');break;
                case 'c':sb.append('2');break;
                case 'd':sb.append('3');break;
                case 'e':sb.append('3');break;
                case 'f':sb.append('3');break;
                case 'g':sb.append('4');break;
                case 'h':sb.append('4');break;
                case 'i':sb.append('4');break;
                case 'j':sb.append('5');break;
                case 'k':sb.append('5');break;
                case 'l':sb.append('5');break;
                case 'm':sb.append('6');break;
                case 'n':sb.append('6');break;
                case 'o':sb.append('6');break;
                case 'p':sb.append('7');break;
                case 'q':sb.append('7');break;
                case 'r':sb.append('7');break;
                case 's':sb.append('7');break;
                case 't':sb.append('8');break;
                case 'u':sb.append('8');break;
                case 'v':sb.append('8');break;
                case 'w':sb.append('9');break;
                case 'x':sb.append('9');break;
                case 'y':sb.append('9');break;
                case 'z':sb.append('9');break;
                }
            } else if (c >= 'A' && c <= 'Z') {
                if (c == 'Z') {
                    sb.append('a');
                } else {
                    sb.append((char)(c + 1 +'a' - 'A'));
                }
            } else {
                sb.append(c);
            }
        }
        output(sb.toString());
    }
    public static void output(String result) {
        System.out.println(result);
    }
}
