package com.github.ltprc.designpattern.creational.singleton;

public class SingletonHungry {
    private static SingletonHungry INSTANCE = new SingletonHungry();
    private SingletonHungry(){}
    public static SingletonHungry getInstance(){
        return INSTANCE;
    }
}
