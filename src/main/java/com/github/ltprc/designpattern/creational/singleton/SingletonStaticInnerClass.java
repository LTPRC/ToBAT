package com.github.ltprc.designpattern.creational.singleton;

public class SingletonStaticInnerClass {
    private static class SingletonHolder{
        private static final SingletonInstance INSTANCE = new SingletonInstance();
    }
    private SingletonStaticInnerClass() {}
    public static final SingletonInstance getInsatance(){
        return SingletonHolder.INSTANCE;
    }
}
