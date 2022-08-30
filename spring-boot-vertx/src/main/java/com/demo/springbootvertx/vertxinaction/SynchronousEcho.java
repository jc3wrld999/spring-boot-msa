package com.demo.springbootvertx.vertxinaction;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SynchronousEcho {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket();
        server.bind(new InetSocketAddress(3000));
        while (true) {
            Socket socket = server.accept();
        }
    }
}
