package com.github.ltprc.javaio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileReaderTest {
    /**
     * һ�ζ��������ļ�
     * @param filePath
     */
    public static void readFile(String filePath) {
        File f = new File(filePath);
        try {
            Reader fr = new FileReader(f);
            // �����ַ����飬�䳤�Ⱦ����ļ��ĳ���
            char[] all = new char[(int) f.length()];
            // ���ַ�������ʽ��ȡ�ļ���������
            fr.read(all);
            System.out.println(all);
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * ���ַ����ļ�
     * @param filePath
     */
    public static void readFileByByte(String filePath) {
        File f = new File(filePath);
        try {
            Reader fr = new FileReader(f);
            // �����ַ����飬�䳤�Ⱦ����ļ��ĳ���
            char[] all = new char[(int) f.length()];
            int temp = -1;
            int index = 0;
            // ���ַ�������ʽ��ȡ�ļ���������
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
     * һ�ζ��������ļ�
     * ����BufferedInputStream���󣬹��췽���д���FileInputStream�������FileInputStream�����ȡЧ�ʡ�
     * @param filePath
     */
    public static void readFileWithBuffer(String filePath) {
        File f = new File(filePath);
        try {
            Reader fr = new FileReader(f);
            Reader br = new BufferedReader(fr);
            // �����ַ����飬�䳤�Ⱦ����ļ��ĳ���
            char[] all = new char[(int) f.length()];
            // ���ַ�������ʽ��ȡ�ļ���������
            br.read(all);
            System.out.println(all);
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * ���ַ����ļ�
     * @param filePath
     */
    public static void readFileByByteWithBuffer(String filePath) {
        File f = new File(filePath);
        try {
            Reader fr = new FileReader(f);
            Reader br = new BufferedReader(fr);
            // �����ַ����飬�䳤�Ⱦ����ļ��ĳ���
            char[] all = new char[(int) f.length()];
            int temp = -1;
            int index = 0;
            // ���ַ�������ʽ��ȡ�ļ���������
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
