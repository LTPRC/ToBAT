package com.github.ltprc.spring;

import java.util.Properties;

public class Person2 {

    private String name;
    
    private int age;
    
    private Food food;
    
    private Properties gift;
    
//    public Person(String name, Integer age, Food food) {
//        super();
//        this.name = name;
//        this.age = age;
//        this.food = food;
//    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    } 

    public Properties getGift() {
        return gift;
    }

    public void setGift(Properties gift) {
        this.gift = gift;
    }
}
