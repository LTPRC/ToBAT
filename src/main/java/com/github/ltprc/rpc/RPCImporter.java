package com.github.ltprc.rpc;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * <p>Importer</p>
 * <p>Implements remote service, and encapsulates the returned result to local customers.</p>
 *
 */
public class RPCImporter<S> {
    @SuppressWarnings("unchecked")
    public S importer(final Class<?> serviceClass, final InetSocketAddress addr) {
        return (S) Proxy.newProxyInstance(serviceClass.getClassLoader(), 
                new Class<?>[]{serviceClass.getInterfaces()[0]}, 
                
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Socket socket = null;
                        ObjectInputStream input = null;
                        ObjectOutputStream output = null;
                        try {
                            socket = new Socket();
                            socket.connect(addr);
                            output = new ObjectOutputStream(socket.getOutputStream());
                            
                            // The following order must be identical to the order in RPCExporter.
                            // 1. Interface name
                            output.writeUTF(serviceClass.getName());
                            System.out.println("interfaceName " + serviceClass.getName());
                            // 2. Method name
                            output.writeUTF(method.getName());
                            System.out.println("methodName " + method.getName());
                            // 3. Parameter types
                            output.writeObject(method.getParameterTypes());
                            for (Class<?> parameterType : method.getParameterTypes()) {
                                if (parameterType != null) {
                                    System.out.println("parameterType " + parameterType.toString());
                                }
                            }
                            // 4. Arguments
                            output.writeObject(args);
                            for (Object argument : args) {
                                if (argument != null) {
                                    System.out.println("argument " + argument.toString());
                                }
                            }
                            
                            input = new ObjectInputStream(socket.getInputStream());
                            return input.readObject();
                        } catch(Exception e) {
                            e.printStackTrace();
                        } finally {
                            if (output != null) {
                                output.close();
                            }
                            if (input != null) {
                                input.close();
                            }
                            if (socket != null) {
                                socket.close();
                            }
                        }
                        return null;
                    }
                });
    }
}
