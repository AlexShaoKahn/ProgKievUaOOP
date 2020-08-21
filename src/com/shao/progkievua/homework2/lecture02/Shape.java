package com.shao.progkievua.homework2.lecture02;

import java.util.ArrayList;
import java.util.List;

public abstract class Shape {
    public List<Point> points = new ArrayList<>();

    public List<Point> getPoints() {
        return new ArrayList<>(points);
    }

    public abstract double getArea();

    public double side(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
    }

    public double getPerimeter() {
        double result = 0;
        for (int i = 0; i < points.size(); i++) {
            if (i == points.size() - 1) result += side(points.get(i), points.get(0));
            else result += side(points.get(i), points.get(i + 1));
        }
        return result;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                ", area=" +
                String.format("%5.2f", getArea()) +
                ", perimeter = " +
                String.format("%5.2f", getPerimeter());
    }
}
