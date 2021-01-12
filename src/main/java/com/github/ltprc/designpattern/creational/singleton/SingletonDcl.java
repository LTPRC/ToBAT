package com.github.ltprc.designpattern.creational.singleton;

public class SingletonDcl {
    private volatile static SingletonInstance INSTANCE;
    private SingletonDcl() {}
    public static SingletonInstance getInstance() {
        //�ȼ��ʵ���Ƿ���ڣ���������ڲŽ��������ͬ����
        if (INSTANCE == null) {
            //ͬ���飬�̰߳�ȫ�Ĵ���ʵ��
            synchronized (SingletonDcl.class) {
                //�ٴμ��ʵ���Ƿ���ڣ���������ڲ������Ĵ���ʵ��
                if (INSTANCE == null) {
                    INSTANCE = new SingletonInstance();
                }
            }
        }
        return INSTANCE;
    }
}
