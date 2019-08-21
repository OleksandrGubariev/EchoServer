import java.io.*;
import java.net.Socket;

public class ClientRW {
    public static void main(String[] args) throws IOException {
        try(Socket socket = new Socket("localhost", 3005);
            BufferedReader consoleBufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader clientBufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter serverBufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))){

            while (true){
                serverBufferedWriter.write(consoleBufferedReader.readLine());
                serverBufferedWriter.write("\n");
                serverBufferedWriter.flush();
                System.out.println(clientBufferedReader.readLine());
            }
        }
    }
}
