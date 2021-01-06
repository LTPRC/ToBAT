package com.github.ltprc.spring.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LoggedBeanByAnnotation {
    public void whatever() {
        System.out.println("whatever");
    }
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = 
            new ClassPathXmlApplicationContext("applicationContextAop.xml");
        LoggedBeanByAnnotation loggedBean = (LoggedBeanByAnnotation)ctx.getBean("loggedBeanByAnnotation");
        loggedBean.whatever();
    }
}
