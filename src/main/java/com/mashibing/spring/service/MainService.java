package com.mashibing.spring.service;

import org.springframework.stereotype.Component;

import com.mashibing.spring.entity.User;

/**
 * �������ҵ���߼�
 * ���磬У���˺������Ƿ���ȷ
 * @author tuoli
 *
 */
//@Component ע��bean �൱��<bean id=""
@Component
public class MainService {
    public User login(String login, String password) {
        System.err.println("Service �ӵ����󣬿�ʼ����");
        return new User();
    }
}
