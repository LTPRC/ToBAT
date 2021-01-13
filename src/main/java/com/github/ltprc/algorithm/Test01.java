package com.github.ltprc.algorithm;

public class Test01 {
    public static void main(String[] args) {
        System.out.println(reverseInt(0));
        System.out.println(reverseInt(100000));
        System.out.println(reverseInt(123));
    }
    public static int reverseInt(int in) {
        if (in <= 0) {
            return -1;
        }
        int out = 0;
        while (in != 0) {
            out = out * 10 + (in - in / 10 * 10);
            in /= 10;
        }
        return out;
    }
}
