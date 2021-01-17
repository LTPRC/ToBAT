package com.github.ltprc.javaio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class AIOServer {
    public AIOServer() {
        try {
            AsynchronousServerSocketChannel assc = AsynchronousServerSocketChannel.open().bind(new InetSocketAddress(ServerConfig.SERVER_PORT));
            assc.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
                @Override
                public void completed(AsynchronousSocketChannel asc, Object attachment) {
                    assc.accept(null, this);
                    try {
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        asc.read(buffer, buffer, new CompletionHandler<Integer, ByteBuffer>() {
                            @Override
                            public void completed(Integer result, ByteBuffer attachment) {
                                System.out.println("result: " + result);
                                attachment.flip();
                                System.out.println(new String(attachment.array()));
                                attachment.clear();
                            }
                            @Override
                            public void failed(Throwable exc, ByteBuffer attachment) {
                                System.out.println("failed");
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            if (null != asc) {
                                asc.close();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                @Override
                public void failed(Throwable exc, Object attachment) {
                    System.out.println("failed");
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        //因为AIO不会阻塞调用进程，因此必须在主线程阻塞，才能保持进程存活。
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws Exception {
        AIOServer aioServer = new AIOServer() ;
    }
}
