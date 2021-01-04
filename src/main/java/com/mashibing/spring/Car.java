package com.mashibing.spring;

public interface Car {
    public String getName();
    public String getPrice();
    
    public default void before() {
        System.out.println(this.toString()+ " begins");
    }
    
    public default void after() {
        System.out.println(this.toString()+ " ends");
    }
}
