package com.github.ltprc.designpattern.creational.singleton;

public class SingletonLazy {
    private static SingletonInstance INSTANCE;
    private SingletonLazy(){}
    public static SingletonInstance getInstance(){
        if (INSTANCE == null) {
            INSTANCE = new SingletonInstance();
        }
        return INSTANCE;
    }
}
