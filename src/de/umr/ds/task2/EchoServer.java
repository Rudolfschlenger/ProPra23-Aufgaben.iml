package de.umr.ds.task2;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;

public class EchoServer {

    public static void main(String[] args) throws IOException {
        // TODO Task 2b)

        int PORT = 1024;
        Executors.newFixedThreadPool(2);
        ServerSocket serverSocket = new ServerSocket(1024);

        try {
            while (true) {

                Socket socket = serverSocket.accept();

                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                String line = reader.readLine();

                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);
                writer.println(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
