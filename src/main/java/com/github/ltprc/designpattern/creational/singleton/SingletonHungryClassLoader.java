package com.github.ltprc.designpattern.creational.singleton;

/**
 * 饿汉式
 * 类加载到内存后，就实例化一个单例，JVM保证线程安全
 * 简单实用，推荐使用！
 * 唯一缺点：不管用到与否，类装载时就完成实例化
 * Class.forName("")
 * （话说你不用的，你装载它干啥）
 */
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
