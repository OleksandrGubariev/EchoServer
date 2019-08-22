package com.gubarev.echoserver.withrw;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerRW  {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(3005)) {
            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    new Thread(new ClientServiceRW(socket)).start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
