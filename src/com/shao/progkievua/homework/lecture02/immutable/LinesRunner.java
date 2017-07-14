package com.shao.progkievua.homework.lecture02.immutable;

public class LinesRunner {
    public static void main(String[] args) {
        Lines lines = new Lines();

        lines.add(new Line(new Point(-10, -10), new Point(10, 10)));
        lines.add(new Line(new Point(20, -10), new Point(-10, -20)));
        lines.add(new Line(new Point(10, -20), new Point(20, -10)));

        System.out.println(lines.toString());
        System.out.println("Longest line: " + lines.longestLine().getLength());
        System.out.println("Summary length: " + lines.sumLength());
    }
}
