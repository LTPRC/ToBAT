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
        Object proxy, //���Ǳ�������󣬶���this, ���ɵĴ������
        Method method, //���÷���
        Object[] args //��������
        ) throws Throwable {
        //ǰ���߼�
        System.out.println(fundProduct.toString() + " before sale()");
        Object o = method.invoke(fundProduct, args);
        //�����߼�
        System.out.println(fundProduct.toString() + " after sale()");
        return o;
    }
    public static void main (String[] args) {
        FundProduct fundProduct = new FundProduct();
        Products product = (Products) Proxy.newProxyInstance (
                //����1 ʹ���ĸ�ClassLoader�ѱ�������󷵻ص��ڴ�
                //�ͱ���������ClassLoader����һ�¾ͺ�
                //Ҳ�����Ǹ��������������������ƽ�е�
                FundProduct.class.getClassLoader(),
                //����2���������Ӧ��ʵ����Щ�ӿ�
//�ȼ���tank.class.getInterfaces()
                new Class[]{Products.class}, 
                //����3 InvocationHandler�������õķ���������Ϊ���������
                new FundProductProxyReflect(fundProduct));
        //���������õ��Ǳ���������sale()����
        //ʵ����ִ�е���InvocationHandler��invoke()����
        product.sale();
    }

}
