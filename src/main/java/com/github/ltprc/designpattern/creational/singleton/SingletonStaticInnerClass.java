package com.github.ltprc.designpattern.creational.singleton;

public class SingletonStaticInnerClass {
    private static class SingletonHolder{
        private static SingletonInstance INSTANCE = new SingletonInstance();
    }
    private SingletonStaticInnerClass() {}
    public static SingletonInstance getInsatance(){
        return SingletonHolder.INSTANCE;
    }
}
