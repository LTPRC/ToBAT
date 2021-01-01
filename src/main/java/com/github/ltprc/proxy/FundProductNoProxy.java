package com.github.ltprc.proxy;

public class FundProductNoProxy extends FundProduct {
    @Override
    public void sale() {
        //«∞÷√¬ﬂº≠
        System.out.println(this.toString() + " before sale()");
        super.sale();
        //∫Û÷√¬ﬂº≠
        System.out.println(this.toString() + " after sale()");
    }
    public static void main (String args[]) {
        Products p = new FundProductNoProxy();
        p.sale();
    }
}
