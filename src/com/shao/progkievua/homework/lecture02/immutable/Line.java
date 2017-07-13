package com.shao.progkievua.homework.lecture02.immutable;

final class Line {
    private final Point start;
    private final Point end;

    Line(Point start, Point end) {
        this.start = start.clone();
        this.end = end.clone();
    }

    double getLength() {
        return Math.sqrt(Math.pow(start.getX() - end.getX(), 2) + Math.pow(start.getY() - end.getY(), 2));
    }
}
