package com.littlesekii.tcpserver.core.server;

import java.net.ServerSocket;
import java.net.Socket;

import com.littlesekii.tcpserver.core.server.connection.TCPServerConnectionClient;

public class TCPServer {
    
    private ServerSocket serverSocket;

    public TCPServer(int serverPort) throws Exception {
        serverSocket = new ServerSocket(serverPort);

        System.out.println("Server started!");

        System.out.println("Waiting for connections.");

        while (true) {
            Socket clientSocket = serverSocket.accept();             

            TCPServerConnectionClient connectionClient = new TCPServerConnectionClient(clientSocket);
            connectionClient.start();
        }
        // outputBuffer.close();
        // inputBuffer.close();
        // clientSocket.close();
        // serverSocket.close();
    }
}
