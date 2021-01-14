package com.github.ltprc.designpattern.creational.builder;

public interface PersonBuilder {
    public PersonBuilder buildHead(String head);
    public PersonBuilder buildBody(String body);
    public PersonBuilder buildClothes(String clothes);
    public Person build();
}
