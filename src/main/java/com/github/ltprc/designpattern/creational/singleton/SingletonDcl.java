package com.github.ltprc.designpattern.creational.singleton;

public class SingletonDcl {
    private volatile static SingletonInstance INSTANCE;
    private SingletonDcl() {}
    public static SingletonInstance getInstance() {
        //先检查实例是否存在，如果不存在才进入下面的同步块
        if (INSTANCE == null) {
            //同步块，线程安全的创建实例
            synchronized (SingletonDcl.class) {
                //再次检查实例是否存在，如果不存在才真正的创建实例
                if (INSTANCE == null) {
                    INSTANCE = new SingletonInstance();
                }
            }
        }
        return INSTANCE;
    }
}
