package com.shao.progkievua.homework2.lecture11.sysinfoserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Runner {
    public static void main(String[] args) {
        StringBuilder answer = new StringBuilder();
        answer.append("<html><head><title>System info</title></head><body>");
        answer
                .append("<table style=\"width: 601.8px;\" border=\"3\" cellspacing=\"5\" cellpadding=\"5\"><tbody><tr><td style=\"text-align: center; width: 557.8px;\" colspan=\"2\"><strong>System info</strong></td></tr><tr><td style=\"width: 284px;\"><pre>Available processors</pre></td><td style=\"width: 273.8px; text-align: right;\">")
                .append(Runtime.getRuntime().availableProcessors())
                .append("</td></tr><tr><td style=\"width: 284px;\"><pre>Free memory (bytes)</pre></td><td style=\"width: 273.8px; text-align: right;\">")
                .append(Runtime.getRuntime().freeMemory())
                .append("</td></tr><tr><td style=\"width: 284px;\"><pre>Maximum memory (bytes)</pre></td><td style=\"width: 273.8px; text-align: right;\">")
                .append(Runtime.getRuntime().maxMemory() == Long.MAX_VALUE ? "no limit" : Runtime.getRuntime().maxMemory())
                .append("</td></tr><tr><td style=\"width: 284px;\"><pre>Total memory available to JVM (bytes)</pre></td><td style=\"width: 273.8px; text-align: right;\">")
                .append(Runtime.getRuntime().totalMemory())
                .append("</td></tr><tr><td style=\"width: 284px;\">os.name</td><td style=\"width: 273.8px; text-align: right;\">")
                .append(System.getProperty("os.name"))
                .append("</td></tr><tr><td style=\"width: 284px;\">os.arch</td><td style=\"width: 273.8px; text-align: right;\">")
                .append(System.getProperty("os.arch"))
                .append("</td></tr><tr><td style=\"width: 284px;\">os.version</td><td style=\"width: 273.8px; text-align: right;\">")
                .append(System.getProperty("os.version"))
                .append("</td></tr><tr><td style=\"width: 284px;\">user.name</td><td style=\"width: 273.8px; text-align: right;\">")
                .append(System.getProperty("user.name"))
                .append("</td></tr></tbody></table>");
        answer.append("</body></html>");


        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            for (; ; ) {
                Socket clientSocket = serverSocket.accept();
                Client client = new Client(clientSocket, answer.toString());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
