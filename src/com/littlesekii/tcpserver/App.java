package com.littlesekii.tcpserver;

import com.littlesekii.tcpserver.core.server.TCPServer;

public class App {
    public static void main(String[] args) throws Exception {
        new TCPServer(1001);
    }
}
