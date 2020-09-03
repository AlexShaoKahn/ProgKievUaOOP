package com.shao.progkievua.homework2.lecture11.groupwebinterface;

import com.shao.progkievua.homework2.lecture03.Gender;
import com.shao.progkievua.homework2.lecture03.NoFreeSpaceInListException;
import com.shao.progkievua.homework2.lecture03.NoStudentFoundException;
import com.shao.progkievua.homework2.lecture03.Student;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

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
                //default -> Collections.shuffle(group.getRealGroupList());
            }

            if (button.contains("delStudent")) {
                int studentHash = Integer.parseInt(button.substring("delStudent".length()));
                for (Student student : group.getRealGroupList()) {
                    if (student.hashCode() == studentHash) {
                        group.delStudent(student);
                        break;
                    }
                }
            }

            if (button.contains("addStudent")) {
                List<String> params = new ArrayList<>();
                String query = button.substring("addStudent".length() + 1);
                for (String s : query.split("&")) {
                    params.add(s.split("=").length > 1 ? s.split("=")[1] : "empty");
                }
                try {
                    group.addStudent(new Student(params.get(1), params.get(0), Integer.parseInt(params.get(2)), Gender.valueOf(params.get(3)), Boolean.valueOf(params.get(4))));
                } catch (NoFreeSpaceInListException e) {
                    e.printStackTrace();
                }
            }

            pw.print(response + (!button.equals("getRecruits") ? group.generateGroupAnswer() : group.generateRecruitsAnswer()));
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoStudentFoundException e) {
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
