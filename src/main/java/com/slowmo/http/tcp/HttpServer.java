package com.slowmo.http.tcp;

import sun.nio.cs.US_ASCII;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class HttpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3002);
        while (true) {
            Socket socket = serverSocket.accept();
            try (InputStream in = socket.getInputStream();
                 OutputStream out = socket.getOutputStream()) {
                //READ request
                byte[] request = HttpUtils.readRequestFully(in);
                System.out.println("  -------------------------------");
                System.out.println(new String(request, US_ASCII.defaultCharset()));
                System.out.println("  -------------------------------");
                // WRITE response
                byte[] response = new Date().toString().getBytes(US_ASCII.defaultCharset());
                out.write(response);
            } finally {
                socket.close();
            }
        }
    }
}
