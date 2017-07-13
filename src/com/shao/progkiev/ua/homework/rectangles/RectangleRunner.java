package com.shao.progkiev.ua.homework.rectangles;

import java.util.Random;

public class RectangleRunner {
    public static void main(String[] args) {
        Random random = new Random();
        Rectangles rectangles = new Rectangles();

        //Creating rectangles
        for (int i = 0; i < random.nextInt(20) + 5; i++) {
            rectangles.addRectangle(new Rectangle(random.nextInt(100), random.nextInt(100)));
        }

        //Result
        System.out.println("Rectangles list:");
        System.out.println(rectangles.toString());
        System.out.println("Rectangles summary area: " + rectangles.getSummaryArea());
    }
}
