import java.io.*;
import java.net.Socket;

public class Threads extends Thread {
    private Socket socket;

    Threads(Socket clientSocket) {
        this.socket = clientSocket;
    }

    @Override
    public void run() {
        try (InputStream inputStream = new BufferedInputStream(socket.getInputStream());
             OutputStream outputStream = new BufferedOutputStream(socket.getOutputStream())) {
            while (true) {
                byte[] buffer = new byte[100];
                inputStream.read(buffer);
                outputStream.write(buffer);
                outputStream.flush();
            }
        } catch (
                Exception e) {
            e.printStackTrace();
        }

    }
}
