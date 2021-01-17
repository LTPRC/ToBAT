package com.github.ltprc.javaio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class BIOServer implements AutoCloseable {
    private ServerSocket serverSocket;
    public BIOServer() throws Exception {
        this.serverSocket = new ServerSocket(ServerConfig.SERVER_PORT);   // ���з���˵�Socket����
        System.out.println("ECHO���������Ѿ������ˣ��÷�����" + ServerConfig.SERVER_PORT + "�˿��ϼ���....");
        boolean serverFlag = true ;
        while(serverFlag) {
            Socket client = this.serverSocket.accept(); // �ȴ��ͻ�������
            Thread clientThread = new Thread(()->{
                try {
                    InputStream inputStream = client.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    boolean clientFlag = true ;
                    while(clientFlag) {
                        System.out.println("*�ȴ��ͻ��˷�������*");
                        String readLine = bufferedReader.readLine();
                        if ("quit".equals(readLine)) {
                            System.out.println("---�ͻ�������---");
                            bufferedReader.close();
                            inputStream.close();
                            client.close();
                            clientFlag = false;
                        } else {
                            System.out.println("���յ��ͻ��˷��͵�����:" + readLine);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }) ;
            clientThread.start(); // �������߳�
        }
    }
    @Override
    public void close() throws IOException {
        this.serverSocket.close();
    }
    public static void main(String[] args) throws Exception {
        BIOServer bioServer = new BIOServer() ;
    }
}
