package com.github.ltprc.javaio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {
    public static void readFile(String filePath) {
        FileInputStream fis = null;
        FileChannel fc = null;
        try {
            fis = new FileInputStream(filePath);
            fc = fis.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int length = fc.read(buffer);
            //Buffer�л�дģʽ�Ͷ�ģʽ
            buffer.flip();
            byte[] ary = new byte[length];
            //�ѻ����������ݻ�ȡ�����ary������
            buffer.get(ary);
            //clear��δ������ݣ����ǰ�position��0��ע�⣡������
            buffer.clear();
            System.out.println(new String(ary));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(null != fc) {
                    fc.close();
                }
                if(null != fis) {
                    fis.close();
                }
            }catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void writeFile(String filePath) {
        String data = "I'm fine.\n";
        FileOutputStream fos = null;
        FileChannel fc = null;
        try {
            //����ڶ�������Ϊfalse���߲���д������׷��д�ļ����Ḳ��
            fos = new FileOutputStream(filePath, true);
            fc = fos.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.put(data.getBytes());
            //Buffer�л�дģʽ�Ͷ�ģʽ
            buffer.flip();
            fc.write(buffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(null != fc) {
                    fc.close();
                }
                if(null != fos) {
                    fos.close();
                }
            }catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        String filePath = "./src/main/resources/javaiotest.txt";
        writeFile(filePath);
        readFile(filePath);
    }
}
