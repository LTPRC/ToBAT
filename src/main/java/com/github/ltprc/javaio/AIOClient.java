package com.github.ltprc.javaio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;

public class AIOClient {
    public AIOClient() {
        String data = "Hello Server!";
        AsynchronousSocketChannel asc;
        try {
            asc = AsynchronousSocketChannel.open();
            asc.connect(new InetSocketAddress(ServerConfig.SERVER_IP, ServerConfig.SERVER_PORT));
            Thread.sleep(1000);
            ByteBuffer buffer = ByteBuffer.wrap(data.getBytes());
            asc.write(buffer).get();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws Exception {
        AIOClient aioServer = new AIOClient() ;
    }
}
