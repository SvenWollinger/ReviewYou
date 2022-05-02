package de.muenchen.reviewyou.Socket;
import java.net.*;
import java.io.*;

public class reviewServer {
    public ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    //TODO: Send the created HTML to browser
    //Space for tipps

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String greeting = in.readLine();
        if("test".equals(greeting)) {
            out.println("The test worked");
        } else {
            out.println("Something went wrong!");
        }
    }

    public void stop() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
}
