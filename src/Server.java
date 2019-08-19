import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3000);
        Socket socket = serverSocket.accept();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String string = bufferedReader.readLine();
        while (string!=null) {
            bufferedWriter.write(string);
            bufferedWriter.flush();
            string = bufferedReader.readLine();
        }
        bufferedReader.close();
        bufferedWriter.close();
    }


}
