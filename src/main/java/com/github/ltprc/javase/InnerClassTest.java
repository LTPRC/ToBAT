package com.github.ltprc.javase;

public class InnerClassTest {
    public void printThis() {
        System.out.println(this.toString());
    }

    /**
     * 静态内部类
     */
    public static class StaticInnerClass {
        public void printThis() {
            System.out.println(this.toString());
        }
    }

    /**
     * 成员内部类
     */
    public class MemberInnerClass {
        public void printThis() {
            System.out.println(this.toString());
        }
    }

    /**
     * 局部内部类
     * 只允许abstract或final修饰符
     */
    public void localInnerClassMethod() {
        class LocalInnerClass {
            public void printThis() {
                System.out.println(this.toString());
            }
        }
        LocalInnerClass localInnerClass = new LocalInnerClass();
        localInnerClass.printThis();
    }

    /**
     * 匿名内部类
     * 1.匿名内部类不能有构造方法。
     * 2.匿名内部类不能定义任何静态成员，方法和类。
     * 3.匿名内部类不能使用public，protected，private，static。
     * 4.只能创建匿名内部类的一个实例。
     * 5.一个匿名内部类一定时在 new 后面，用其隐含实现一个接口或实现一个类。
     * 6.因匿名内部类为局部内部类，所以，局部内部类的所有限制都对其有效。
     * 7.内部类只能访问外部类的静态变量或静态方法。
     * 8.内部类当中的 this 指的是匿名内部类本身，如果使用外部类中的 this，则“外部类.this”。
     */
    public void anonymousInnerClassMethod() {
        AnonymousInnerClass anonymousInnerClass = new AnonymousInnerClass() {
            @Override
            public void printThis() {
                // TODO Auto-generated method stub
                System.out.println(this.toString());
            }
        };
        anonymousInnerClass.printThis();
    }
    interface AnonymousInnerClass {
        public void printThis();
    }

    public static void main(String[] args) {
        InnerClassTest innerClassTest = new InnerClassTest();
        innerClassTest.printThis();
        InnerClassTest.StaticInnerClass staticInnerClass = new InnerClassTest.StaticInnerClass();
        staticInnerClass.printThis();
        innerClassTest.localInnerClassMethod();
        innerClassTest.anonymousInnerClassMethod();
    }
}
