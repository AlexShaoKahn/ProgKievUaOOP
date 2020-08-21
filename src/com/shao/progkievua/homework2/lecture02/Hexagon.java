package com.shao.progkievua.homework2.lecture02;

import java.io.Serializable;

public class Hexagon extends Rectangle implements Serializable {
    public Hexagon() {
    }

    public Hexagon(Point p1, Point p2, Point p3, Point p4, Point p5, Point p6) {
        super(p1, p2, p3, p4);
        points.add(p5);
        points.add(p6);
    }

    @Override
    public double getArea() {
        int l1 = 0;
        for (int i = 0; i < points.size(); i++) {
            if (i == points.size() - 1) l1 += points.get(i).getX() * points.get(0).getY();
            else l1 += points.get(i).getX() * points.get(i + 1).getY();
        }
        int l2 = 0;
        for (int i = 0; i < points.size(); i++) {
            if (i == points.size() - 1) l2 += points.get(i).getY() * points.get(0).getX();
            else l2 += points.get(i).getY() * points.get(i + 1).getX();
        }
        return (double) Math.abs((l1 - l2)) / 2;
    }
}
