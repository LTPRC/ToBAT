package com.github.ltprc.designpattern.creational.factory;

public class SquareFactory implements FactoryMethod {
    @Override
    public Shape getShape() {
        return new Square();
    }
}
