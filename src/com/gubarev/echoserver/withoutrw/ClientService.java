package com.gubarev.echoserver.withoutrw;

import java.io.*;
import java.net.Socket;

public class ClientService implements Runnable {
    private Socket socket;

    ClientService(Socket clientSocket) {
        this.socket = clientSocket;
    }

    @Override
    public void run() {
        try (InputStream inputStream = new BufferedInputStream(socket.getInputStream());
             OutputStream outputStream = new BufferedOutputStream(socket.getOutputStream())) {
            while (true) {
                byte[] buffer = new byte[100];
                int countByte = inputStream.read(buffer);
                byte[] bufferForOS = new byte[countByte];
                int i = 0;
                while (i < countByte) {
                    bufferForOS[i] = buffer[i];
                    i++;
                }
                outputStream.write(bufferForOS);
                outputStream.flush();
            }
        } catch (
                Exception e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (Exception s) {
            s.printStackTrace();
        }

    }
}
