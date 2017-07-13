package com.shao.progkievua.homework.lecture02.immutable;

final class Point implements Cloneable {
    private final double x;
    private final double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    double getX() {
        return x;
    }

    double getY() {
        return y;
    }

    @Override
    protected Point clone() {
        return new Point(x, y);
    }
}
