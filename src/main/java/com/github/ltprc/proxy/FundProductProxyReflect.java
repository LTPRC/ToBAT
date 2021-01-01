package com.github.ltprc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class FundProductProxyReflect implements InvocationHandler {
    FundProduct fundProduct;
    public FundProductProxyReflect(FundProduct fundProduct) {
        this. fundProduct = fundProduct;
    }
    public Object invoke(
        Object proxy, //不是被代理对象，而是this, 生成的代理对象
        Method method, //调用方法
        Object[] args //方法参数
        ) throws Throwable {
        //前置逻辑
        System.out.println(fundProduct.toString() + " before sale()");
        Object o = method.invoke(fundProduct, args);
        //后置逻辑
        System.out.println(fundProduct.toString() + " after sale()");
        return o;
    }
    public static void main (String[] args) {
        FundProduct fundProduct = new FundProduct();
        Products product = (Products) Proxy.newProxyInstance (
                //参数1 使用哪个ClassLoader把被代理对象返回到内存
                //和被代理对象的ClassLoader保持一致就好
                //也可以是父类加载器，但不可以是平行的
                FundProduct.class.getClassLoader(),
                //参数2被代理对象应该实现哪些接口
//等价于tank.class.getInterfaces()
                new Class[]{Products.class}, 
                //参数3 InvocationHandler处理被调用的方法，参数为被代理对象
                new FundProductProxyReflect(fundProduct));
        //看起来调用的是被代理对象的sale()方法
        //实际上执行的是InvocationHandler的invoke()方法
        product.sale();
    }

}
