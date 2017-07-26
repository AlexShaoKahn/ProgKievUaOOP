package com.shao.progkievua.homework.lecture01.rectangles;

import java.util.ArrayList;
import java.util.List;

public class Rectangles {
    private List<Rectangle> rectangles;

    public Rectangles() {
        rectangles = new ArrayList<>();
    }

    public void addRectangle(Rectangle rectangle) {
        rectangles.add(rectangle);
    }

    public int getSummaryArea() {
        int result = 0;
        for (Rectangle rectangle : rectangles) {
            result += rectangle.getArea();
        }
        return result;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < rectangles.size() - 1; i++) {
            result.append(i + 1).append(": ").append(rectangles.get(i).toString()).append("\n");
        }
        return result.toString();
    }
}
