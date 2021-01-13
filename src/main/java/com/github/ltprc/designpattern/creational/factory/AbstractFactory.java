package com.github.ltprc.designpattern.creational.factory;

public abstract class AbstractFactory {
    abstract Circle getCircle();
    abstract Rectangle getRectangle();
    abstract Square getSquare();
}
