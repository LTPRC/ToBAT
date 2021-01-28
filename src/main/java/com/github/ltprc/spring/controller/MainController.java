package com.github.ltprc.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.ltprc.spring.entity.User;
import com.github.ltprc.spring.service.MainService;

@Component
public class MainController {
    /**
     * 负责逻辑跳转
     * 在web环境下，由controller层线接入
     * @return
     */
    @Autowired
    private MainService srv;
    public String list() {
        String loginName = "zhangfg";
        String password = "123456";
        User user = srv.login(loginName, password);
        return null == user ? "Login failed" : "Login succeeded";
    }
}
