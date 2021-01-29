package com.github.ltprc.designpattern.structural.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class FundProductProxyCglib implements MethodInterceptor {
    public Object intercept(
            Object o,
            Method method,
            Object[] objects,
            MethodProxy methodProxy) throws Throwable {
        //ǰ���߼�
        System.out.println(this.toString() + " before sale()");
        Object result = null;
        result = methodProxy.invokeSuper(o, objects);
        //�����߼�
        System.out.println(this.toString() + " after sale()");
        return result;
    }
    public static void main (String[] args) {
        //��ǿ�� Enhancer
        Enhancer enhancer = new Enhancer();
        //��̬��������Tank�������
        enhancer.setSuperclass(FundProduct.class);
        //���������� TimeMethodInterceptor �൱��InvocationHandler
        enhancer.setCallback(new FundProductProxyCglib());
        FundProduct fundProduct = (FundProduct) enhancer.create();
        fundProduct.sale();
    }
}
