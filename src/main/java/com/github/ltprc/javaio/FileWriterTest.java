package com.github.ltprc.javaio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileWriterTest {
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
            Writer fw = new FileWriter(f, true);
            fw.write(data);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 逐字符写字符串
     * @param filePath
     */
    public static void writeFileByByte(String filePath) {
        String data = "Hello world!\n";
        //如果文件不存在会自动创建
        File f = new File(filePath);
        try {
            //如果第二个参数为false或者不填写，则不能追加写文件，会覆盖
            Writer fw = new FileWriter(f, true);
            for (int i = 0; i < data.length(); i++) {
                fw.write(data.charAt(i));
            }
            fw.close();
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
            Writer fw = new FileWriter(f, true);
            Writer bw = new BufferedWriter(fw);
            //因为是字节流，所以要转化成字节数组进行输出
            bw.write(data);
            bw.flush();
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 逐字符写字符串
     * @param filePath
     */
    public static void writeFileByByteWithBuffer(String filePath) {
        String data = "Hello world!\n";
        //如果文件不存在会自动创建
        File f = new File(filePath);
        try {
            //如果第二个参数为false或者不填写，则不能追加写文件，会覆盖
            Writer fw = new FileWriter(f, true);
            Writer bw = new BufferedWriter(fw);
            for (int i = 0; i < data.length(); i++) {
                fw.write(data.charAt(i));
            }
            bw.flush();
            bw.close();
            fw.close();
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
