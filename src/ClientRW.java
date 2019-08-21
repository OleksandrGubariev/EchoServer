import java.io.*;
import java.net.Socket;

public class ClientRW {
    public static void main(String[] args) throws IOException {
        try(Socket socket = new Socket("localhost", 3005);
            BufferedReader consoleBufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader clientBufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter serverBufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))){

            while (true){
                String string = consoleBufferedReader.readLine();
                serverBufferedWriter.write(string);
                serverBufferedWriter.write("\n");
                serverBufferedWriter.flush();
                string = clientBufferedReader.readLine();
                System.out.println(string);
            }
        }
    }
}
