package com.github.ltprc.javaio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileReaderTest {
    /**
     * 一次读完整个文件
     * @param filePath
     */
    public static void readFile(String filePath) {
        File f = new File(filePath);
        try {
            Reader fr = new FileReader(f);
            // 创建字符数组，其长度就是文件的长度
            char[] all = new char[(int) f.length()];
            // 以字符流的形式读取文件所有内容
            fr.read(all);
            System.out.println(all);
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 逐字符读文件
     * @param filePath
     */
    public static void readFileByByte(String filePath) {
        File f = new File(filePath);
        try {
            Reader fr = new FileReader(f);
            // 创建字符数组，其长度就是文件的长度
            char[] all = new char[(int) f.length()];
            int temp = -1;
            int index = 0;
            // 以字符流的形式读取文件所有内容
            while ((temp = fr.read()) != -1) {
                all[index++] = (char) temp;
            }
            System.out.println(all);
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 一次读完整个文件
     * 创建BufferedInputStream对象，构造方法中传递FileInputStream对象，提高FileInputStream对象读取效率。
     * @param filePath
     */
    public static void readFileWithBuffer(String filePath) {
        File f = new File(filePath);
        try {
            Reader fr = new FileReader(f);
            Reader br = new BufferedReader(fr);
            // 创建字符数组，其长度就是文件的长度
            char[] all = new char[(int) f.length()];
            // 以字符流的形式读取文件所有内容
            br.read(all);
            System.out.println(all);
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 逐字符读文件
     * @param filePath
     */
    public static void readFileByByteWithBuffer(String filePath) {
        File f = new File(filePath);
        try {
            Reader fr = new FileReader(f);
            Reader br = new BufferedReader(fr);
            // 创建字符数组，其长度就是文件的长度
            char[] all = new char[(int) f.length()];
            int temp = -1;
            int index = 0;
            // 以字符流的形式读取文件所有内容
            while ((temp = br.read()) != -1) {
                all[index++] = (char) temp;
            }
            System.out.println(all);
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        String filePath = "./src/main/resources/javaiotest.txt";
        readFile(filePath);
        readFileByByte(filePath);
        readFileWithBuffer(filePath);
        readFileByByteWithBuffer(filePath);
    }
}
