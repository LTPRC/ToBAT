package com.github.ltprc.designpattern.creational.factory;

public class CircleFactory implements FactoryMethod {
    @Override
    public Shape getShape() {
        return new Circle();
    }
}
