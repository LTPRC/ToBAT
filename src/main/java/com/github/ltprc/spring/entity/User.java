package com.github.ltprc.spring.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class User {
    @Value("zhangfg")
    private String loginName;
    @Value("123456")
    private String password;
}
