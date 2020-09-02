package com.shao.progkievua.homework2.lecture11.groupwebinterface;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Collections;

public class GroupClient implements Runnable {
    private Socket socket;
    WGroup group;
    private Thread thread;

    public GroupClient(Socket socket, WGroup group) {
        this.socket = socket;
        this.group = group;
        this.thread = new Thread(this);
        thread.setDaemon(true);
        this.thread.start();
    }

    @Override
    public void run() {
        String result = "default";
        try (InputStream is = socket.getInputStream(); OutputStream os = socket.getOutputStream()) {
            PrintWriter pw = new PrintWriter(os);
            String response = "HTTP/1.1 200 OK\r\n" + "Content-Type: text/html\r\n\r\n";
            byte[] bytes = new byte[is.available()];
            is.read(bytes);
            String button = parseGet(bytes);
            switch (button) {
                case "bySurname" -> group.sortBySurname();
                case "byName" -> group.sortByName();
                case "byAge" -> group.sortByAge();
                default -> Collections.shuffle(group.getRealGroupList());
            }
            pw.print(response + (!button.equals("getRecruits") ? group.generateGroupAnswer() : group.generateRecruitsAnswer()));
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String parseGet(byte[] bytes) {
        String result = new String();
        final String s1 = "GET /";
        final String s2 = " HTTP/";
        String bString = new String(bytes, StandardCharsets.UTF_8);
        if (bString.contains(s1) && bString.contains(s2)) {
            int a = bString.indexOf(s1);
            int b = bString.indexOf(s2);
            if ((b) - (a + s1.length()) > 0) result = bString.substring(a + s1.length(), b);
        }
        return result;
    }
}
