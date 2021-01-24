package com.github.ltprc.rpc;

public class EchoServiceImpl implements EchoService{
    public String echo(String ping) {
        return ping == null ? "NULL --> Echo" : ping + " --> Echo";
    }
}
