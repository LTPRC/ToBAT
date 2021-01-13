package com.github.ltprc.designpattern.creational.factory;

public class FactoryTest {
    public static void main(String[] args) {
        useNoFactory();
        useSimpleFactory();
        useFactoryMethod();
        useAbstractFactory();
    }
    public static void useNoFactory() {
        Shape shape1 = new Circle();
        Shape shape2 = new Rectangle();
        Shape shape3 = new Square();
        System.out.println(shape1);
        System.out.println(shape2);
        System.out.println(shape3);
    }
    public static void useSimpleFactory() {
        SimpleFactory simpleFactory = new SimpleFactory();
        Shape shape1 = simpleFactory.getShape("CIRCLE");
        Shape shape2 = simpleFactory.getShape("RECTANGLE");
        Shape shape3 = simpleFactory.getShape("SQUARE");
        System.out.println(shape1);
        System.out.println(shape2);
        System.out.println(shape3);
    }
    public static void useFactoryMethod() {
        FactoryMethod circleFactory = new CircleFactory();
        Shape shape1 = circleFactory.getShape();
        FactoryMethod rectangleFactory = new RectangleFactory();
        Shape shape2 = rectangleFactory.getShape();
        FactoryMethod squareFactory = new SquareFactory();
        Shape shape3 = squareFactory.getShape();
        System.out.println(shape1);
        System.out.println(shape2);
        System.out.println(shape3);
    }
    public static void useAbstractFactory() {
        AbstractFactory abstractFactory = new AbstractFactoryImpl();
        Shape shape1 = abstractFactory.getCircle();
        Shape shape2 = abstractFactory.getRectangle();
        Shape shape3 = abstractFactory.getSquare();
        System.out.println(shape1);
        System.out.println(shape2);
        System.out.println(shape3);
    }
}
