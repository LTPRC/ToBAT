package com.github.ltprc.designpattern.creational.singleton;

/**
 * ����ʽ
 * ����ص��ڴ�󣬾�ʵ����һ��������JVM��֤�̰߳�ȫ
 * ��ʵ�ã��Ƽ�ʹ�ã�
 * Ψһȱ�㣺�����õ������װ��ʱ�����ʵ����
 * Class.forName("")
 * ����˵�㲻�õģ���װ������ɶ��
 */
public class SingletonHungry {
    private static SingletonInstance INSTANCE = new SingletonInstance();
    private SingletonHungry(){}
    public static SingletonInstance getInstance(){
        return INSTANCE;
    }
}
