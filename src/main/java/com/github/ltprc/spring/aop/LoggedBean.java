package com.github.ltprc.spring.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LoggedBean {
    public void whatever() {
        System.out.println("whatever");
    }
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = 
            new ClassPathXmlApplicationContext("applicationContextAop.xml");
        LoggedBean loggedBean = (LoggedBean)ctx.getBean("loggedBean");
        loggedBean.whatever();
    }
}
