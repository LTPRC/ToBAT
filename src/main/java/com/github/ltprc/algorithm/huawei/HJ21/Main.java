package com.github.ltprc.algorithm.huawei.HJ21;

import java.util.Scanner;

/**
 * ��Ŀ����
 * ���������������зǳ���Ҫ�Ķ��������ǵ���ôһ�㲻��˵�����ܾ�ȫ�����ˡ��۹���. ������Ԩ��Ҫ������֮���ټ�һ�����룬��Ȼ�򵥵�Ҳ��ȫ��
 * ����Ԩ��ԭ��һ��BBS�ϵ�����Ϊzvbo9441987,Ϊ�˷�����䣬��ͨ��һ���㷨���������任��YUANzhi1987������������������ֺͳ�����ݣ���ô���������ˣ����ҿ�����Ŀ�ŵ��ط������۵ĵط�����������֪�����������롣
 * ������ô�任�ģ���Ҷ�֪���ֻ��ϵ���ĸ�� 1--1�� abc--2, def--3, ghi--4, jkl--5, mno--6, pqrs--7, tuv--8 wxyz--9, 0--0,����ô�򵥣�Ԩ�Ӱ������г��ֵ�Сд��ĸ����ɶ�Ӧ�����֣����ֺ������ķ��Ŷ������任��
 * ������������û�пո񣬶������г��ֵĴ�д��ĸ����Сд֮��������һλ���磺X���ȱ��Сд����������һλ��������y����򵥰ɡ���ס��z��������aŶ��
 * 
 * ����������
 * �����������������ݡ�������һ�����ģ����볤�Ȳ�����100���ַ�������ֱ���ļ���β
 * 
 * ���������
 * ���Ԩ������������
 * 
 * ������ʾ��
 * �ύ��ʱ����Ҫ�����ύimport���
 * ������ȷ��ΪMain�Ҳ�Ҫʹ��public��������η���
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
