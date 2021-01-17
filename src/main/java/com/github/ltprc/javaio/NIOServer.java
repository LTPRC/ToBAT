package com.github.ltprc.javaio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;

public class NIOServer {
    public NIOServer() {
        try {
            //����һ��ServerSocketChannel���󣬰󶨶˿ڲ����óɷ�����ģʽ��
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(ServerConfig.SERVER_PORT), 1024);
            //����������Ҫ������ServerSocketChannel��ʹ��������ģʽ���ǾͲ���NIO��
            serverSocketChannel.configureBlocking(false);
            //��ServerSocketChannel����Selector����
            Selector selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            //ѭ�������ϵĴ�Selector�л�ȡ׼��������Channel���ʼ��ʱ��Selectorֻ������һ��ServerSocketChannel
            //���Ǻ����пͻ�������ʱ����ѿͻ��˶�Ӧ��ChannelҲ����Selector����
            while (true) {
                //��һ��������������Channel׼������ʱ���߳���1000���᷵�ء�
                selector.select(1000);
                //��ȡ���е�׼��������Channel��SelectionKey�а�����Channel��Ϣ
                Set<SelectionKey> selectionKeySet = selector.selectedKeys();
                //������ÿ��Channel���ɴ���
                for (SelectionKey selectionKey : selectionKeySet) {
                    //���Channel�Ѿ���Ч�ˣ�����������Channel�Ѿ��ر��ˣ�
                    if(!selectionKey.isValid()) {
                        continue;
                    }
                    //�ж�Channel����ľ����¼���������пͻ������ӣ���������
                    if (selectionKey.isAcceptable()) {
                        try {
                            acceptConnection(selectionKey, selector);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    //����пͻ��˿��Զ�ȡ�����ˣ����ȡ����Ȼ�󷵻�����
                    if (selectionKey.isReadable()) {
                        try {
                            String data = readFromSelectionKey(selectionKey);
                            System.out.println(data);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                //������ɺ�ѷ��ص�Set��գ����������´λ����ٷ�����ЩKey�������ظ�����
                selectionKeySet.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //�ͻ��˽������ӵķ���
    private static void acceptConnection(SelectionKey selectionKey, Selector selector) throws Exception {
        System.out.println("accept connection...");
        //SelectionKey�а���ѡȡ������Channel����Ϣ�����ǿ��Դ��л�ȡ�����ڽ���������˵��ֻ����ServerSocketChannel���ܴ�����
        //���������԰���ת��ServerSocketChannel����
        ServerSocketChannel ssc = ((ServerSocketChannel) selectionKey.channel());
        //��ȡ�ͻ��˶�Ӧ��SocketChannel
        SocketChannel socketChannel = ssc.accept();
        //Ҳ��Ҫ���óɷ�����ģʽ
        socketChannel.configureBlocking(false);
        //�ѿͻ��˵�Channel����Selector��أ�֮����������ݿ��Զ�ȡʱ���ᱻselect����
        socketChannel.register(selector, SelectionKey.OP_READ);
    }
    //�ӿͻ��˶�ȡ���ݵ��ַ���
    private static String readFromSelectionKey(SelectionKey selectionKey) throws Exception {
        //��SelectionKey�а���ѡȡ������Channel����Ϣ��Channel��ȡ����
        SocketChannel socketChannel = ((SocketChannel) selectionKey.channel());
        //��ȡ���ݵ�ByteBuffer��
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        int len = socketChannel.read(byteBuffer);
        if (len < 0) {
            //�������-1��˵�������Ѿ���������ˣ����Թر�
            socketChannel.close();
            selectionKey.cancel();
            return "";
        } else if (len == 0) {
            //ʲô��û����
            return "";
        }
        byteBuffer.flip();
        doWrite(selectionKey, "Hello Nio");
        return new String(byteBuffer.array(), 0, len);
    }
    private static void doWrite(SelectionKey selectionKey, String responseMessage) throws Exception{
        System.out.println("Output message...");
        SocketChannel socketChannel = ((SocketChannel) selectionKey.channel());
        ByteBuffer byteBuffer = ByteBuffer.allocate(responseMessage.getBytes().length);
        byteBuffer.put(responseMessage.getBytes());
        byteBuffer.flip();
        socketChannel.write(byteBuffer);
    }
    public static void main(String[] args) {
        NIOServer nioServer = new NIOServer();
    }
}
