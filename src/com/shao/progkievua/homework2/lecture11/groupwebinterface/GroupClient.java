package com.shao.progkievua.homework2.lecture11.groupwebinterface;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.Callable;

public class GroupClient implements Callable {
    private Socket socket;
    private String answer;

    public GroupClient(Socket socket, String answer) {
        this.socket = socket;
        this.answer = answer;
    }

    @Override
    public Integer call() {
        try (InputStream is = socket.getInputStream(); OutputStream os = socket.getOutputStream()) {
            PrintWriter pw = new PrintWriter(os);
            byte[] req = new byte[is.available()];
            String response = "HTTP/1.1 200 OK\r\n" + "Content-Type: text/html\r\n\r\n";
            pw.print(response + answer);
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 777;
    }
}
