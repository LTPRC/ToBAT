package com.github.ltprc.proxy;

public class FundProductProxy implements Products{
    Products product;
    public FundProductProxy (FundProduct product) {
        this.product = product;
    }
    public void sale() {
        //ǰ���߼�
        System.out.println(product.toString() + " before sale()");
        product.sale();
        //�����߼�
        System.out.println(product.toString() + " after sale()");
    }
    public static void main (String args[]) {
        Products p = new FundProductProxy(new FundProduct());
        p.sale();
    }
}
