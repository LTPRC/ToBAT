package com.mashibing.spring;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mashibing.spring.controller.MainController;

public class TestGetBean {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = 
                new ClassPathXmlApplicationContext("applicationContext.xml");
        
        
        
//        Person person = (Person)ctx.getBean("person");
//        Person person2 = (Person)ctx.getBean("person2");
//        Person human = (Person)ctx.getBean("human");
//        Person star = (Person)ctx.getBean("star");

//        System.out.println(ToStringBuilder.reflectionToString(person));
//        System.out.println(ToStringBuilder.reflectionToString(person2));
//        System.out.println(ToStringBuilder.reflectionToString(human));
//        System.out.println(ToStringBuilder.reflectionToString(star));
        
//        CollectionContainer collectionContainer  = (CollectionContainer)ctx.getBean("cC");
//        System.out.println(ToStringBuilder.reflectionToString(collectionContainer));
        

//        Person2 person2 = (Person2)ctx.getBean("person2");
//        System.out.println(ToStringBuilder.reflectionToString(person2));
        
//        A a = new A();
//        B b = new B();
//        C c = new C();
//        A a = (A)ctx.getBean("a");
//        B b = (B)ctx.getBean("b");
//        C c = (C)ctx.getBean("c");
        A a = (A)ctx.getBean("A");
        B b = (B)ctx.getBean("B");
        C c = (C)ctx.getBean("C");
        System.out.println(ToStringBuilder.reflectionToString(a));
        System.out.println(ToStringBuilder.reflectionToString(b));
        System.out.println(ToStringBuilder.reflectionToString(c));
        

//        Car car = new CarFactory().getCar("Audi");
//        Car car = ctx.getBean("car", Car.class);
//        System.out.println(car.getName());
        
        MainController controller = ctx.getBean("mainController", MainController.class);
        controller.list();
        
        Object companyBean = ctx.getBean("companyBean");
        System.out.println("bean:" + companyBean);

    }
}
