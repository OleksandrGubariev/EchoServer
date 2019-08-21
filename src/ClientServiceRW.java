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
                String string = bufferedReader.readLine();
                bufferedWriter.write(string);
                bufferedWriter.write("\n");
                bufferedWriter.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
