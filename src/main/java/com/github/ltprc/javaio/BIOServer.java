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
        this.serverSocket = new ServerSocket(ServerConfig.SERVER_PORT);   // 进行服务端的Socket启动
        System.out.println("ECHO服务器端已经启动了，该服务在" + ServerConfig.SERVER_PORT + "端口上监听....");
        boolean serverFlag = true ;
        while(serverFlag) {
            Socket client = this.serverSocket.accept(); // 等待客户端连接
            Thread clientThread = new Thread(()->{
                try {
                    InputStream inputStream = client.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    boolean clientFlag = true ;
                    while(clientFlag) {
                        System.out.println("*等待客户端发送数据*");
                        String readLine = bufferedReader.readLine();
                        if ("quit".equals(readLine)) {
                            System.out.println("---客户端下线---");
                            bufferedReader.close();
                            inputStream.close();
                            client.close();
                            clientFlag = false;
                        } else {
                            System.out.println("接收到客户端发送的数据:" + readLine);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }) ;
            clientThread.start(); // 启动多线程
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
