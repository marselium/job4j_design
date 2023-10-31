package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    String line = in.readLine();
                    while (!line.isEmpty()) {
                        if (line.startsWith("GET")) {
                            if (line.contains("msg=Hello")) {
                                out.write("Hello".getBytes());
                            } else if (line.contains("msg=Bye")) {
                                out.write("Server is closed".getBytes());
                                server.close();
                            } else {
                                out.write("What".getBytes());
                            }
                        }
                        line = in.readLine();
                    }
                    out.flush();
                }
            }
        }
    }

}
