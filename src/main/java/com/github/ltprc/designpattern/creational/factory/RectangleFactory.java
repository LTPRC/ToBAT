package com.github.ltprc.designpattern.creational.factory;

public class RectangleFactory implements FactoryMethod {
    @Override
    public Shape getShape() {
        return new Rectangle();
    }
}
