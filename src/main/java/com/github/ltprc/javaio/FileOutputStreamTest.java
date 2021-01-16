package com.github.ltprc.javaio;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileOutputStreamTest {
    /**
     * 一次写完整个字符串
     * @param filePath
     */
    public static void writeFile(String filePath) {
        String data = "Hello world!\n";
        //如果文件不存在会自动创建
        File f = new File(filePath);
        try {
            //如果第二个参数为false或者不填写，则不能追加写文件，会覆盖
            OutputStream out = new FileOutputStream(f, true);
            //因为是字节流，所以要转化成字节数组进行输出
            byte[] b = data.getBytes();
            out.write(b);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 逐字节写字符串
     * @param filePath
     */
    public static void writeFileByByte(String filePath) {
        String data = "Hello world!\n";
        //如果文件不存在会自动创建
        File f = new File(filePath);
        try {
            //如果第二个参数为false或者不填写，则不能追加写文件，会覆盖
            OutputStream out = new FileOutputStream(f, true);
            //因为是字节流，所以要转化成字节数组进行输出
            byte[] b = data.getBytes();
            for (int i = 0; i < b.length; i++) {
                out.write(b[i]);
            }
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 一次写完整个字符串
     * 创建BufferedOutputStream对象，构造方法中传递FileOutputStream对象，提高FileOutputStream对象读取效率。
     * @param filePath
     */
    public static void writeFileWithBuffer(String filePath) {
        String data = "Hello world!\n";
        //如果文件不存在会自动创建
        File f = new File(filePath);
        try {
            //如果第二个参数为false或者不填写，则不能追加写文件，会覆盖
            OutputStream out = new FileOutputStream(f, true);
            OutputStream bos = new BufferedOutputStream(out);
            //因为是字节流，所以要转化成字节数组进行输出
            byte[] b = data.getBytes();
            bos.write(b);
            bos.flush();
            bos.close();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 逐字节写字符串
     * @param filePath
     */
    public static void writeFileByByteWithBuffer(String filePath) {
        String data = "Hello world!\n";
        //如果文件不存在会自动创建
        File f = new File(filePath);
        try {
            //如果第二个参数为false或者不填写，则不能追加写文件，会覆盖
            OutputStream out = new FileOutputStream(f, true);
            OutputStream bos = new BufferedOutputStream(out);
            //因为是字节流，所以要转化成字节数组进行输出
            byte[] b = data.getBytes();
            for (int i = 0; i < b.length; i++) {
                bos.write(b[i]);
            }
            bos.flush();
            bos.close();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        String filePath = "./src/main/resources/javaiotest.txt";
        writeFile(filePath);
        writeFileByByte(filePath);
        writeFileWithBuffer(filePath);
        writeFileByByteWithBuffer(filePath);
    }
}
