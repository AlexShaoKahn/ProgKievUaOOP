package com.shao.progkievua.homework2.lecture11.groupwebinterface;

import com.shao.progkievua.homework2.lecture03.NoFreeSpaceInListException;
import com.shao.progkievua.homework2.lecture03.Student;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Runner {
    public static void main(String[] args) {
        WGroup group = new WGroup();
        try {
            fillGroup(group);
        } catch (NoFreeSpaceInListException e) {
            e.printStackTrace();
        }

        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            for (; !serverSocket.isClosed(); ) {
                Socket clientSocket = serverSocket.accept();
                GroupClient client = new GroupClient(clientSocket, group);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void fillGroup(WGroup group) throws NoFreeSpaceInListException {
        for (int i = 0; i < 10; i++) {
            group.addStudent(new Student());
        }
    }
}
