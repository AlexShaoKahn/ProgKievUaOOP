package com.shao.progkievua.homework2.lecture09.doublecola;

import java.util.LinkedList;
import java.util.Queue;

public class Runner {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        queue.add("Sheldon");
        queue.add("Leonard");
        queue.add("Volovitc");
        queue.add("Kutrapalli");
        queue.add("Penny");

        doubleCola(queue, 2);
        System.out.println(queue);
    }

    public static void doubleCola(Queue<String> queue, int colaCups) {
        for (int i = 0; i < colaCups; i++) {
            queue.add(queue.peek());
            queue.add(queue.poll());
        }
    }
}
