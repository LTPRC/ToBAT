package com.github.ltprc.designpattern.creational.factory;

public class AbstractFactoryImpl extends AbstractFactory {
    @Override
    Circle getCircle() {
        return null;
    }
    @Override
    Rectangle getRectangle() {
        return new Rectangle();
    }
    @Override
    Square getSquare() {
        return new Square();
    }
}
