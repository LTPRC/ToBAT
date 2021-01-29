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
        //前置逻辑
        System.out.println(this.toString() + " before sale()");
        Object result = null;
        result = methodProxy.invokeSuper(o, objects);
        //后置逻辑
        System.out.println(this.toString() + " after sale()");
        return result;
    }
    public static void main (String[] args) {
        //增强器 Enhancer
        Enhancer enhancer = new Enhancer();
        //动态代理类是Tank类的子类
        enhancer.setSuperclass(FundProduct.class);
        //方法拦截器 TimeMethodInterceptor 相当于InvocationHandler
        enhancer.setCallback(new FundProductProxyCglib());
        FundProduct fundProduct = (FundProduct) enhancer.create();
        fundProduct.sale();
    }
}
