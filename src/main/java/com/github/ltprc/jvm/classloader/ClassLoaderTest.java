package com.github.ltprc.jvm.classloader;

public class ClassLoaderTest {
    public static void main(String[] args) {
        System.out.println(ClassLoaderTest.class);
        
        System.out.println(ClassLoaderTest.class.getClassLoader());
        System.out.println(ClassLoaderTest.class.getClassLoader().getClass());
        System.out.println(ClassLoaderTest.class.getClassLoader().getClass().getClassLoader());

        System.out.println(ClassLoaderTest.class.getClassLoader().getParent());
        System.out.println(ClassLoaderTest.class.getClassLoader().getParent().getClass());
        System.out.println(ClassLoaderTest.class.getClassLoader().getParent().getClass().getClassLoader());
        
        System.out.println(ClassLoaderTest.class.getClassLoader().getParent().getParent());
    }
}
