package com.mashibing.spring.service;

import org.springframework.stereotype.Component;

import com.mashibing.spring.entity.User;

/**
 * 处理具体业务逻辑
 * 比如，校验账号密码是否正确
 * @author tuoli
 *
 */
//@Component 注册bean 相当于<bean id=""
@Component
public class MainService {
    public User login(String login, String password) {
        System.err.println("Service 接到请求，开始处理");
        return new User();
    }
}
