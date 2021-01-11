package com.github.ltprc.javase;

public class InnerClassTest {
    public void printThis() {
        System.out.println(this.toString());
    }

    /**
     * ��̬�ڲ���
     */
    public static class StaticInnerClass {
        public void printThis() {
            System.out.println(this.toString());
        }
    }

    /**
     * ��Ա�ڲ���
     */
    public class MemberInnerClass {
        public void printThis() {
            System.out.println(this.toString());
        }
    }

    /**
     * �ֲ��ڲ���
     * ֻ����abstract��final���η�
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
     * �����ڲ���
     * 1.�����ڲ��಻���й��췽����
     * 2.�����ڲ��಻�ܶ����κξ�̬��Ա���������ࡣ
     * 3.�����ڲ��಻��ʹ��public��protected��private��static��
     * 4.ֻ�ܴ��������ڲ����һ��ʵ����
     * 5.һ�������ڲ���һ��ʱ�� new ���棬��������ʵ��һ���ӿڻ�ʵ��һ���ࡣ
     * 6.�������ڲ���Ϊ�ֲ��ڲ��࣬���ԣ��ֲ��ڲ�����������ƶ�������Ч��
     * 7.�ڲ���ֻ�ܷ����ⲿ��ľ�̬������̬������
     * 8.�ڲ��൱�е� this ָ���������ڲ��౾�����ʹ���ⲿ���е� this�����ⲿ��.this����
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
