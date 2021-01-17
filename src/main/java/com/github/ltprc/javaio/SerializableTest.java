package com.github.ltprc.javaio;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableTest implements Serializable {
    private static final long serialVersionUID = 7689029289977800530L;
    public Object clone() {
        SerializableTest newObject = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            newObject = (SerializableTest) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // 别忘了关闭流
            if (null != bos) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != oos) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != bis) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != ois) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return newObject;
    }
    class SubObject implements Serializable {
        private static final long serialVersionUID = 467144107914040827L;
    }
    public static void main(String[] args) {
        SerializableTest object1 = new SerializableTest();
        SerializableTest object2 = (SerializableTest) object1.clone();
        System.out.println(object1);
        System.out.println(object2);
    }
}
