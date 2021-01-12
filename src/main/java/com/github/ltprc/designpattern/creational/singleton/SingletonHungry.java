package com.github.ltprc.designpattern.creational.singleton;

public class SingletonHungry {
    private static SingletonInstance INSTANCE = new SingletonInstance();
    private SingletonHungry(){}
    public static SingletonInstance getInstance(){
        return INSTANCE;
    }
}
