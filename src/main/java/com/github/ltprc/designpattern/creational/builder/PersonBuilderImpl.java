package com.github.ltprc.designpattern.creational.builder;

public class PersonBuilderImpl implements PersonBuilder {
    Person person = new Person();
    @Override
    public PersonBuilder buildHead(String head) {
        person.setHead(head);
        return this;
    }
    @Override
    public PersonBuilder buildBody(String body) {
        person.setBody(body);
        return this;
    }
    @Override
    public PersonBuilder buildClothes(String clothes) {
        person.setClothes(clothes);
        return this;
    }
    @Override
    public Person build() {
        return person;
    }
    public static void main(String[] args) {
        PersonBuilder personBuilder = new PersonBuilderImpl();
        Person person = personBuilder.buildHead("ugly head").buildBody("short body").buildClothes("naked").build();
        System.out.println(person.toString());
    }
}
