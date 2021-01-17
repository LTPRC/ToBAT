package com.github.ltprc.algorithm;

public class Factorial {
    public static void main(String args[]) {
        int num = 10;
        for (int counter = 0; counter <= num; counter++){
            System.out.printf("%d! = %d\n", counter,
            factorial(counter));
        }
    }
    public static long factorial(long number) {
        if (number <= 1)
            return 1;
        else
            return number * factorial(number - 1);
    }
}
