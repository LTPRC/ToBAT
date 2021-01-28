package com.github.ltprc.spring;

public class CarFactory2 {
    public Car getCar(String name) {
        if ("audi".equals(name)) {
            return new Audi();
        } else {
            return new BMW();
        }
    }
}
