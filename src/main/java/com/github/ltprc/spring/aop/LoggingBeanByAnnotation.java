package com.github.ltprc.spring.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingBeanByAnnotation {
    @Before("execution(* com.github.ltprc.spring.aop.**.*(..))")
    public void before() {
        System.out.println("====before====");
    }
    @After("execution(* com.github.ltprc.spring.aop.**.*(..))")
    public void after() {
        System.out.println("====after====");
    }
    @AfterReturning("execution(* com.github.ltprc.spring.aop.**.*(..))")
    public void afterReturning() {
        System.out.println("====afterReturning====");
    }
    @AfterThrowing("execution(* com.github.ltprc.spring.aop.**.*(..))")
    public void afterThrowing() {
        System.out.println("====afterThrowing====");
    }
    @Around("execution(* com.github.ltprc.spring.aop.**.*(..))")
    public void around() {
        System.out.println("====around====");
    }
}
