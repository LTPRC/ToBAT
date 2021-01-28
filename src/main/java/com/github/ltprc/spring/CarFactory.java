package com.github.ltprc.spring;

public class CarFactory {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Car getCar() {
        if ("audi".equals(name)) {
            return new Audi();
        } else {
            return new BMW();
        }
    }
}
