package com.github.ltprc.rpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * <p>Exporter</p>
 * <p>Publishes local service as remote service to be implemented by other importers.</p>
 *
 */
public class RPCExporter {
    // Create a thread pool with fixed and enough size.
    static Executor executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    
    public static void exporter(String hostName, int port) throws Exception {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(hostName, port));
        try {
            while(true) {
                executor.execute(new ExporterTask(serverSocket.accept()));
            }
        } finally {
            serverSocket.close();
        }
    }
}

/**
 * <p>Exporter Task</p>
 * <p>Collects input stream, processes it by the related RPC method and arguments, and transmits it to output stream.</p>
 *
 */
class ExporterTask implements Runnable {
    Socket socket = null;
    
    public ExporterTask(Socket socket) {
        this.socket = socket;
    }
    
    public void run() {
        ObjectInputStream input = null;
        ObjectOutputStream output = null;
        try {
            input = new ObjectInputStream(socket.getInputStream());
            // The following order must be identical to the order in RPCImporter.
            // 1. Interface name
            String interfaceName = input.readUTF();
            System.out.println("interfaceName " + interfaceName);
            Class<?> service = Class.forName(interfaceName);
            // 2. Method name
            String methodName = input.readUTF();
            System.out.println("methodName " + methodName);
            // 3. Parameter types
            Class<?>[] parameterTypes = (Class<?>[])input.readObject();
            for (Class<?> parameterType : parameterTypes) {
                if (parameterType != null) {
                    System.out.println("parameterType " + parameterType.toString());
                }
            }
            // 4. Arguments
            Object[] arguments = (Object[])input.readObject();
            for (Object argument : arguments) {
                if (argument != null) {
                    System.out.println("argument " + argument.toString());
                }
            }
            
            Method method = service.getMethod(methodName, parameterTypes);
            Object result = method.invoke(service.newInstance(), arguments);
            
            output = new ObjectOutputStream(socket.getOutputStream());
            
            output.writeObject(result);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
