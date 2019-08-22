package com.gubarev.echoserver.withoutrw;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(3002)) {
            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    new ClientService(socket).start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
