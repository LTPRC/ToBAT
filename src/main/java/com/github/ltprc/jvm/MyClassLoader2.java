package com.github.ltprc.jvm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyClassLoader2 extends ClassLoader {
    private String classPrePath = "./";
    public String getClassPrePath() {
        return classPrePath;
    }
    public void setClassPrePath(String classPrePath) {
        this.classPrePath = classPrePath;
    }
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        File f = new File(classPrePath, name.replace(".", "/").concat(".class"));
        if(!f.exists()) return super.loadClass(name);
        try {
            InputStream is = new FileInputStream(f);
            byte[] b = new byte[is.available()];
            is.read(b);
            return defineClass(name, b, 0, b.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.loadClass(name);
    }
    public static void main(String[] args) throws Exception {
        ClassLoader l = new MyClassLoader2();
        Class clazz = l.loadClass("com.github.ltprc.jvm.???");
        Class clazz1 = l.loadClass("com.github.ltprc.jvm.???");
        System.out.println(clazz == clazz1);
        /**
         * TODO Define ???
         */
        //??? h = (???)clazz.newInstance();
        //h.m();
        System.out.println(l.getClass().getClassLoader());
        System.out.println(l.getParent());
        System.out.println(getSystemClassLoader());
    }
}