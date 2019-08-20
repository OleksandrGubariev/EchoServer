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
                byte[] arrayForIS = new byte[100];
                inputStreamConsole.read(arrayForOS);
                outputStream.write(arrayForOS);
                outputStream.flush();
                inputStream.read(arrayForIS);
                System.out.println(new String(arrayForIS));
            }
        }
    }
}