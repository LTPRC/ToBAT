package com.github.ltprc.algorithm.huawei.HJ17;

import java.util.Scanner;

/**
 * 
 * 题目描述
 * 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
输入：
合法坐标为A(或者D或者W或者S) + 数字（两位以内）
坐标之间以;分隔。
非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
下面是一个简单的例子 如：
A10;S20;W10;D30;X;A1A;B10A11;;A10;
处理过程：
起点（0,0）
+   A10   =  （-10,0）
+   S20   =  (-10,-20)
+   W10  =  (-10,-10)
+   D30  =  (20,-10)
+   x    =  无效
+   A1A   =  无效
+   B10A11   =  无效
+  一个空 不影响
+   A10  =  (10,-10)
结果 （10， -10）
注意请处理多组输入输出
 * 
 * 输入描述：
 * 一行字符串
 * 
 * 输出描述：
 * 最终坐标，以逗号分隔
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
