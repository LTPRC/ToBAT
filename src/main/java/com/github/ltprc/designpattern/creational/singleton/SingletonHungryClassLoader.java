package com.github.ltprc.designpattern.creational.singleton;

public class SingletonHungryClassLoader {
    private static SingletonInstance INSTANCE = null;
    static {
        INSTANCE = new SingletonInstance();
    }
    private SingletonHungryClassLoader(){}
    public static SingletonInstance getInstance(){
        return INSTANCE;
    }
}
