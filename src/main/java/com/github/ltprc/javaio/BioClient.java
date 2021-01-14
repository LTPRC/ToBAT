package com.github.ltprc.javaio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class BioClient implements AutoCloseable {
    private Socket client;
    public BioClient() throws IOException {
        this.client = new Socket(ServerConfig.SERVER_IP, ServerConfig.SERVER_PORT);
        System.out.println("�Ѿ��ɹ������ӵ��˷������ˣ����Խ�����Ϣ�ķ��ʹ���");
        OutputStream outputStream = client.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true ;
        while(flag) {
            System.out.println("�������ַ���������quit�����ж����ӡ�");
            String data = reader.readLine(); // ����ĳ�������ַ�������������BufferedReader.readline()��������
            bufferedWriter.write(data);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            if ("quit".equals(data)) {
                System.exit(-1);
            }
        }
    }
    @Override
    public void close() throws IOException {
        this.client.close();
    }
    public static void main(String[] args) throws Exception {
        BioClient bioClient = new BioClient() ;
    }
}
