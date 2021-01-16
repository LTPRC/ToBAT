package com.github.ltprc.javaio;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileOutputStreamTest {
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
            OutputStream out = new FileOutputStream(f, true);
            //��Ϊ���ֽ���������Ҫת�����ֽ�����������
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
     * ���ֽ�д�ַ���
     * @param filePath
     */
    public static void writeFileByByte(String filePath) {
        String data = "Hello world!\n";
        //����ļ������ڻ��Զ�����
        File f = new File(filePath);
        try {
            //����ڶ�������Ϊfalse���߲���д������׷��д�ļ����Ḳ��
            OutputStream out = new FileOutputStream(f, true);
            //��Ϊ���ֽ���������Ҫת�����ֽ�����������
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
            OutputStream out = new FileOutputStream(f, true);
            OutputStream bos = new BufferedOutputStream(out);
            //��Ϊ���ֽ���������Ҫת�����ֽ�����������
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
     * ���ֽ�д�ַ���
     * @param filePath
     */
    public static void writeFileByByteWithBuffer(String filePath) {
        String data = "Hello world!\n";
        //����ļ������ڻ��Զ�����
        File f = new File(filePath);
        try {
            //����ڶ�������Ϊfalse���߲���д������׷��д�ļ����Ḳ��
            OutputStream out = new FileOutputStream(f, true);
            OutputStream bos = new BufferedOutputStream(out);
            //��Ϊ���ֽ���������Ҫת�����ֽ�����������
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
