import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 3000);
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine()+"\n";
        while (!(string.equals("exit\n"))) {
            byte [] array = new byte[1024];
            outputStream.write(string.getBytes());
            inputStream.read(array);
            System.out.println(new String(array));
            string = scanner.nextLine()+"\n";
        }
        inputStream.close();
        outputStream.close();
    }

}
