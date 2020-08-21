package com.shao.progkievua.homework2.lecture02;

import java.io.Serializable;

public class Rectangle extends Triangle implements Serializable {

    public Rectangle() {
    }

    public Rectangle(Point p1, Point p2, Point p3, Point p4) {
        super(p1, p2, p3);
        points.add(p4);
    }

    @Override
    public double getArea() {
        return side(points.get(0), points.get(1)) * side(points.get(2), points.get(3));
    }
}
