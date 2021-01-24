package com.github.ltprc.rpc;

import java.net.InetSocketAddress;

public class RPCRun {
    public static void main(String[] args) throws Exception {
        new Thread(new Runnable() {
            public void run() {
                try {
                    RPCExporter.exporter("localhost", 8088);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        ).start();
        RPCImporter<EchoService> importer = new RPCImporter<EchoService>();
        EchoService echo = importer.importer(EchoServiceImpl.class, new InetSocketAddress("localhost", 8088));
        System.out.println(echo.echo("Test"));
        System.out.println(echo.echo(null));
    }
}
