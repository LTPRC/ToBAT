package com.github.ltprc.juc;

import java.util.concurrent.atomic.LongAdder;

public class LongAdderTest {
    public static void main(String[] args) {
        LongAdder count = new LongAdder();
        count.increment();
        System.out.println(count.longValue());
    }
}
