package com.gubarev.echoserver.withoutrw;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("localhost", 3002);
             OutputStream outputStream = new BufferedOutputStream(socket.getOutputStream());
             InputStream inputStream = new BufferedInputStream(socket.getInputStream());
             InputStream inputStreamConsole = new BufferedInputStream(System.in)) {
            while (true) {
                byte[] arrayForOS = new byte[100];
                int countByte = inputStreamConsole.read(arrayForOS);
                byte[] buffer = new byte[countByte];
                int i = 0;
                while (i < countByte) {
                    buffer[i] = arrayForOS[i];
                    i++;
                }
                outputStream.write(buffer);
                outputStream.flush();
                inputStream.read(buffer);
                System.out.println(new String(buffer));
            }
        }
    }
}