package com.github.ltprc.jvm;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class MyClassLoader extends ClassLoader {
    private String classPrePath = "./";
    public String getClassPrePath() {
        return classPrePath;
    }
    public void setClassPrePath(String classPrePath) {
        this.classPrePath = classPrePath;
    }
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File f = new File(classPrePath, name.replace(".", "/").concat(".class"));
        try {
            FileInputStream fis = new FileInputStream(f);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int b = 0;
            while ((b = fis.read()) !=0) {
                baos.write(b);
            }
            byte[] bytes = baos.toByteArray();
            baos.close();
            fis.close();
            return defineClass(name, bytes, 0, bytes.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.findClass(name); //throws ClassNotFoundException
    }
    public static void main(String[] args) throws Exception {
        ClassLoader l = new MyClassLoader();
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