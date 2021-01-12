package com.github.ltprc.designpattern.creational.singleton;

public enum SingletonEnum {
    INSTANCE;
    private static SingletonInstance SINGLETON_INSTANCE = new SingletonInstance();
    public SingletonInstance getInstance() {
        return SINGLETON_INSTANCE;
    }
}
