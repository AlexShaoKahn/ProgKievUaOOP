package com.shao.progkievua.homework2.lecture11.groupwebinterface;

import com.shao.progkievua.homework2.lecture03.NoFreeSpaceInListException;
import com.shao.progkievua.homework2.lecture03.Student;
import com.shao.progkievua.homework2.lecture09.groupmod.MGroup;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Runner {
    public static void main(String[] args) {
        MGroup group = new MGroup();
        try {
            fillGroup(group);
        } catch (NoFreeSpaceInListException e) {
            e.printStackTrace();
        }


        StringBuilder answer = new StringBuilder();
        answer.append("<table border=\"5\"><tbody><tr><td style=\"text-align: center;\" colspan=\"5\"><strong>Students group</strong></td></tr><tr><td><strong>Surname</strong></td><td><strong>Name</strong></td><td><strong>Age</strong></td><td><strong>Gender</strong></td><td><strong>Dorms</strong></td></tr>");
        for (Student student : group.getRealGroupList()) {
            answer
                    .append("<tr>")
                    .append("<td>").append(student.getSurname()).append("</td>")
                    .append("<td>").append(student.getName()).append("</td>")
                    .append("<td>").append(student.getAge()).append("</td>")
                    .append("<td>").append(student.getGender().toString().toLowerCase()).append("</td>")
                    .append("<td>").append(student.isLivesInDormitory() ? "yes" : "no").append("</td>")
                    .append("</tr>");
        }
        answer.append("</tbody></table>");
        answer.append("<br/><button onclick=\"window.location.href='/bySurname'\">By surname</button>");

        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            for (; ; ) {
                Socket clientSocket = serverSocket.accept();
                GroupClient client = new GroupClient(clientSocket, answer.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void fillGroup(MGroup group) throws NoFreeSpaceInListException {
        for (int i = 0; i < 10; i++) {
            group.addStudent(new Student());
        }
    }
}
