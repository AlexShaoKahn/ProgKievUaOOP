package com.shao.progkievua.homework.lecture02.immutable;

public final class Line {
    private final Point start;
    private final Point end;

    public Line(Point start, Point end) {
        this.start = start.clone();
        this.end = end.clone();
    }

    public double getLength() {
        return Math.sqrt(Math.pow(start.getX() - end.getX(), 2) + Math.pow(start.getY() - end.getY(), 2));
    }
}
