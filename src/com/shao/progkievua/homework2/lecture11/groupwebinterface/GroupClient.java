package com.shao.progkievua.homework2.lecture11.groupwebinterface;

import com.shao.progkievua.homework2.lecture11.sysinfoserver.Client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class GroupClient extends Client {
    public GroupClient(Socket socket, String answer) {
        super(socket, answer);
    }

    @Override
    public void run() {
        try (InputStream is = getSocket().getInputStream(); OutputStream os = getSocket().getOutputStream()) {
            PrintWriter pw = new PrintWriter(os);
            byte[] req = new byte[is.available()];
            String response = "HTTP/1.1 200 OK\r\n" + "Content-Type: text/html\r\n\r\n";
            pw.print(response + getAnswer());

//            if (is.available() > 0) {
//                is.read(req);
//                for (byte b : req) {
//                    System.out.print((char) b);
//                }
//                System.out.println();
//            }

            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
