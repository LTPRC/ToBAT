package com.github.ltprc.javaio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

public class AsynchronousFileChannelTest {
    /**
     * 通过Future读取数据
     * @param filePath
     */
    public static void readFileByFuture(String filePath) {
        Path path = Paths.get(filePath);
        AsynchronousFileChannel afc = null;
        try {
            afc = AsynchronousFileChannel.open(path, StandardOpenOption.READ);
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            long position = 0;
            Future<Integer> operation = afc.read(buffer, position);
            while (!operation.isDone());
            buffer.flip();
            System.out.println(new String(buffer.array()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != afc) {
                    afc.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 通过CompletionHandler读取数据
     * @param filePath
     */
    public static void readFileByCompletionHandler(String filePath) {
        Path path = Paths.get(filePath);
        AsynchronousFileChannel afc = null;
        try {
            afc = AsynchronousFileChannel.open(path, StandardOpenOption.READ);
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            long position = 0;
            afc.read(buffer, position, buffer, new CompletionHandler<Integer, ByteBuffer>() {
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
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != afc) {
                    afc.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 通过Future写入读取数据
     * @param filePath
     */
    public static void writeFileByFuture(String filePath) {
        Path path = Paths.get(filePath);
        AsynchronousFileChannel afc = null;
        String data = "I'm fine, too.\n";
        try {
            afc = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            long position = 0;
            buffer.put(data.getBytes());
            //Buffer切换写模式和读模式
            buffer.flip();
            Future<Integer> operation = afc.write(buffer, position);
            while (!operation.isDone());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(null != afc) {
                    afc.close();
                }
            }catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 通过CompletionHandler写入读取数据
     * @param filePath
     */
    public static void writeFileByCompletionHandler(String filePath) {
        Path path = Paths.get(filePath);
        AsynchronousFileChannel afc = null;
        String data = "I'm fine, too!\n";
        try {
            afc = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            long position = 0;
            buffer.put(data.getBytes());
            //Buffer切换写模式和读模式
            buffer.flip();
            afc.write(buffer, position, buffer, new CompletionHandler<Integer, ByteBuffer>() {
                @Override
                public void completed(Integer result, ByteBuffer attachment) {
                    System.out.println("bytes written: " + result);
                }
                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {
                    System.out.println("failed");
                }
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(null != afc) {
                    afc.close();
                }
            }catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        String filePath = "./src/main/resources/javaiotest.txt";
        writeFileByFuture(filePath);
        readFileByFuture(filePath);
        writeFileByCompletionHandler(filePath);
        readFileByCompletionHandler(filePath);
    }
}
