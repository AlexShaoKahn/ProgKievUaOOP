package com.shao.progkievua.homework2.lecture11.sysinfoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client implements Runnable {
    private Socket socket;
    private String answer;
    private Thread thread;

    public Client(Socket socket, String answer) {
        this.socket = socket;
        this.answer = answer;
        thread = new Thread(this);
        thread.start();
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        try (InputStream is = socket.getInputStream(); OutputStream os = socket.getOutputStream()) {
            PrintWriter pw = new PrintWriter(os);
            byte[] req = new byte[is.available()];
            String response = "HTTP/1.1 200 OK\r\n" + "Content-Type: text/html\r\n\r\n";
            pw.print(response + answer);
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
