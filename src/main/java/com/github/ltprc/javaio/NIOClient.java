package com.github.ltprc.javaio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Set;

public class NIOClient {
    public NIOClient() {
        try {
            //����һ��SocketChannel����
            SocketChannel socketChannel = SocketChannel.open();
            //���óɷ�����ģʽ
            socketChannel.configureBlocking(false);
            //����һ��ѡ����������SocketChannel����selector����
            Selector selector = Selector.open();
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
            //���������ӵ�����������������أ������ӽ�����ɺ�SocketChannel�ͻᱻѡȡ����
            socketChannel.connect(new InetSocketAddress(ServerConfig.SERVER_IP, ServerConfig.SERVER_PORT));
            //���������εĴ�Selector��ѡȡ���Ѿ�������Channel������������У�Selectorֻ�����һ��SocketChannel
            while (true) {
                selector.select(1000);
                Set<SelectionKey> selectionKeySet = selector.selectedKeys();
                for (SelectionKey selectionKey : selectionKeySet) {
                    if(!selectionKey.isValid()) {
                        continue;
                    }
                    //���ӽ�����ɺ�Ĳ�����ֱ�ӷ�����������
                    if (selectionKey.isConnectable()) {
                        if(socketChannel.finishConnect()) {
                            socketChannel.register(selector, SelectionKey.OP_READ);
                            try {
                                doWriteRequest(((SocketChannel) selectionKey.channel()));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    //�����ǰ�Ѿ����Զ������ˣ�˵��������Ѿ���Ӧ���ˣ���ȡ����
                    if (selectionKey.isReadable()) {
                        try {
                            doRead(selectionKey);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                //���ͬ��Ҫ������е�Key
                selectionKeySet.removeAll(selectionKeySet);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //��������
    private static void doWriteRequest(SocketChannel socketChannel) throws Exception {
        String data = "Hello Server!";
        System.out.println("start connect...");
        //����ByteBuffer���󣬻��������
        byte[] bytes = data.getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(bytes.length);
        byteBuffer.put(bytes);
        byteBuffer.flip();
        //д����
        socketChannel.write(byteBuffer);
        if(!byteBuffer.hasRemaining()) {
            System.out.println("Send request success...");
        }
    }
    //��ȡ����˵���Ӧ
    private static void doRead(SelectionKey selectionKey) throws Exception {
        SocketChannel socketChannel = ((SocketChannel) selectionKey.channel());
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        int len = socketChannel.read(byteBuffer);
        System.out.println("Recv:" + new String(byteBuffer.array(), 0, len));
    }
    public static void main(String[] args) {
        NIOClient nioClient = new NIOClient();
    }
}
