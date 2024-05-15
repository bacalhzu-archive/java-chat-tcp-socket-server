package com.littlesekii.tcpserver.core.server.connection;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

import com.littlesekii.tcpdata.TCPTransferDataExample;

public class TCPServerConnectionClient extends Thread {

    Socket connectionClientSocket;

    public TCPServerConnectionClient(Socket connectionClientSocket) {
        this.connectionClientSocket = connectionClientSocket;
    }

    @Override
    public void run() {

        try {
            System.out.println("Connection with client " + this.connectionClientSocket.getInetAddress() + ":" + this.connectionClientSocket.getPort() + " established.");
            
            ObjectOutputStream outputBuffer = new ObjectOutputStream(connectionClientSocket.getOutputStream());
            ObjectInputStream inputBuffer = new ObjectInputStream(connectionClientSocket.getInputStream());

            while (true) {
                TCPTransferDataExample data = new TCPTransferDataExample();

                data = (TCPTransferDataExample) inputBuffer.readObject();

                String message = data.getData().toUpperCase();

                if (message.equals("bye"))
                    break;

                data = new TCPTransferDataExample();
                data.setData(message);

                outputBuffer.writeObject(data);
                outputBuffer.flush();
            }
        } catch (SocketException e) {
            switch (e.getMessage()) {
                case "Connection reset":
                System.out.println("Connection with client " + this.connectionClientSocket.getInetAddress() + ":" + this.connectionClientSocket.getPort() + " ended.");
                    break;
                default:
                    e.printStackTrace();                     
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
