package com.github.ltprc.designpattern.creational.singleton;

public class SingletonLazyThreadSafe {
    private static SingletonInstance INSTANCE;
    private SingletonLazyThreadSafe(){}
    public static synchronized SingletonInstance getInstance(){
        if (INSTANCE == null) {
            INSTANCE = new SingletonInstance();
        }
        return INSTANCE;
    }
}
