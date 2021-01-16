package com.github.ltprc.javaio;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileInputStreamTest {
    /**
     * һ�ζ��������ļ�
     * @param filePath
     */
    public static void readFile(String filePath) {
        File f = new File(filePath);
        try {
            InputStream in = new FileInputStream(f);
            byte[] b = new byte[(int) f.length()];
            in.read(b);
            in.close();
            System.out.println(new String(b));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * ���ֽڶ��ļ�
     * @param filePath
     */
    public static void readFileByByte(String filePath) {
        File f = new File(filePath);
        try {
            InputStream in = new FileInputStream(f);
            byte[] b = new byte[(int) f.length()];
            int temp = -1;
            int index = 0;
            while ((temp = in.read()) != -1) {
                b[index++] = (byte) temp;
            }
            in.close();
            System.out.println(new String(b));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * һ�ζ��������ļ�
     * ����BufferedInputStream���󣬹��췽���д���FileInputStream�������FileInputStream�����ȡЧ�ʡ�
     * @param filePath
     */
    public static void readFileWithBuffer(String filePath) {
        File f = new File(filePath);
        try {
            InputStream in = new FileInputStream(f);
            InputStream bis = new BufferedInputStream(in);
            byte[] b = new byte[(int) f.length()];
            bis.read(b);
            bis.close();
            in.close();
            System.out.println(new String(b));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * ���ֽڶ��ļ�
     * ����BufferedInputStream���󣬹��췽���д���FileInputStream�������FileInputStream�����ȡЧ�ʡ�
     * @param filePath
     */
    public static void readFileByByteWithBuffer(String filePath) {
        File f = new File(filePath);
        try {
            InputStream in = new FileInputStream(f);
            InputStream bis = new BufferedInputStream(in);
            byte[] b = new byte[(int) f.length()];
            int temp = -1;
            int index = 0;
            while ((temp = bis.read()) != -1) {
                b[index++] = (byte) temp;
            }
            bis.close();
            in.close();
            System.out.println(new String(b));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
