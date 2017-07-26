package com.shao.progkievua.homework.lecture02.immutable;

public final class Point implements Cloneable {
    private final double x;
    private final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    protected Point clone() {
        return new Point(x, y);
    }
}
