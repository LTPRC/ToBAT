package com.github.ltprc.javaio;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UDPClient {
    public UDPClient() {
        long n = 10000L;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        try {
            dos.writeLong(n);
            byte[] buf = baos.toByteArray();
            System.out.println(buf.length);
            DatagramPacket dp = new DatagramPacket(buf, buf.length, 
                    new InetSocketAddress(ServerConfig.SERVER_IP, ServerConfig.SERVER_PORT));
            DatagramSocket ds = new DatagramSocket();
            ds.send(dp);
            ds.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String args[]) {
        UDPClient client = new UDPClient();
    }
}
