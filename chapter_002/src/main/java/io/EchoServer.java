package io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(EchoServer.class.getName());

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    while (!(str = in.readLine()).isEmpty()) {
                        System.out.println(str);
                        if (str.contains("Exit")) {
                            out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                            out.write("Server close.".getBytes());
                            server.close();
                            break;
                        }
                        if (!server.isClosed() && str.contains("Hello")) {
                            out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                            out.write("Hello, dear friend.".getBytes());
                            break;
                        } else if (!server.isClosed() && !str.contains("Hello")) {
                            String any = str.split("=")[1].split(" ")[0];
                            out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                            out.write(any.getBytes());
                            break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            LOG.error("IOException", e);
        }
    }
}