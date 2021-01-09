package com.github.ltprc.jvm.jol;

import org.openjdk.jol.info.ClassLayout;

public class JolTest {
    static class M {
        int a;
        boolean b;
        String s;
    }
    public static void main(String[] args) {
        M m = new M();
        System.out.println(ClassLayout.parseInstance(m).toPrintable());
    }
}
