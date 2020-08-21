package com.shao.progkievua.homework2.lecture02;

import java.io.Serializable;

public class Triangle extends Shape implements Serializable {

    public Triangle() {
    }

    public Triangle(Point p1, Point p2, Point p3) {
        points.add(p1);
        points.add(p2);
        points.add(p3);
    }


    @Override
    public double getArea() {
        double side1 = side(points.get(0), points.get(1));
        double side2 = side(points.get(1), points.get(2));
        double side3 = side(points.get(2), points.get(1));
        double p = (side1 + side2 + side3) / 2;
        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
