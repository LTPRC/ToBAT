package com.github.ltprc.javaio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileWriterTest {
    /**
     * һ��д�������ַ���
     * @param filePath
     */
    public static void writeFile(String filePath) {
        String data = "Hello world!\n";
        //����ļ������ڻ��Զ�����
        File f = new File(filePath);
        try {
            //����ڶ�������Ϊfalse���߲���д������׷��д�ļ����Ḳ��
            Writer fw = new FileWriter(f, true);
            fw.write(data);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * ���ַ�д�ַ���
     * @param filePath
     */
    public static void writeFileByByte(String filePath) {
        String data = "Hello world!\n";
        //����ļ������ڻ��Զ�����
        File f = new File(filePath);
        try {
            //����ڶ�������Ϊfalse���߲���д������׷��д�ļ����Ḳ��
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
     * һ��д�������ַ���
     * ����BufferedOutputStream���󣬹��췽���д���FileOutputStream�������FileOutputStream�����ȡЧ�ʡ�
     * @param filePath
     */
    public static void writeFileWithBuffer(String filePath) {
        String data = "Hello world!\n";
        //����ļ������ڻ��Զ�����
        File f = new File(filePath);
        try {
            //����ڶ�������Ϊfalse���߲���д������׷��д�ļ����Ḳ��
            Writer fw = new FileWriter(f, true);
            Writer bw = new BufferedWriter(fw);
            //��Ϊ���ֽ���������Ҫת�����ֽ�����������
            bw.write(data);
            bw.flush();
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * ���ַ�д�ַ���
     * @param filePath
     */
    public static void writeFileByByteWithBuffer(String filePath) {
        String data = "Hello world!\n";
        //����ļ������ڻ��Զ�����
        File f = new File(filePath);
        try {
            //����ڶ�������Ϊfalse���߲���д������׷��д�ļ����Ḳ��
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
