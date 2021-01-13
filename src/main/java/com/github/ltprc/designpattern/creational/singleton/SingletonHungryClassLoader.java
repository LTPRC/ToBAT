package com.github.ltprc.designpattern.creational.singleton;

/**
 * ����ʽ
 * ����ص��ڴ�󣬾�ʵ����һ��������JVM��֤�̰߳�ȫ
 * ��ʵ�ã��Ƽ�ʹ�ã�
 * Ψһȱ�㣺�����õ������װ��ʱ�����ʵ����
 * Class.forName("")
 * ����˵�㲻�õģ���װ������ɶ��
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
