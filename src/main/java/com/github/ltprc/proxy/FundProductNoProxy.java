package com.github.ltprc.proxy;

public class FundProductNoProxy extends FundProduct {
    @Override
    public void sale() {
        //ǰ���߼�
        System.out.println(this.toString() + " before sale()");
        super.sale();
        //�����߼�
        System.out.println(this.toString() + " after sale()");
    }
    public static void main (String args[]) {
        Products p = new FundProductNoProxy();
        p.sale();
    }
}
