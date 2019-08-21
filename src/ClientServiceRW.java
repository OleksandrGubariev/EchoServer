import java.io.*;
import java.net.Socket;

public class ClientServiceRW extends Thread {
    private Socket socket;

    ClientServiceRW(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {

            while (true) {
                bufferedWriter.write(bufferedReader.readLine());
                bufferedWriter.write("\n");
                bufferedWriter.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
