package com.shao.progkievua.homework.lecture02.immutable;

import java.util.ArrayList;

public class Lines {
    private ArrayList<Line> lines;

    public Lines() {
        lines = new ArrayList<>();
    }

    public void add(Line line) {
        lines.add(line);
    }

    public double sumLength() {
        double summ = 0;
        for (Line line : lines) {
            summ += line.getLength();
        }
        return summ;
    }

    public Line longestLine() {
        double length = -1;
        Line longestLine = null;
        for (Line line : lines) {
            if (length < line.getLength()) {
                length = line.getLength();
                longestLine = line;
            }
        }
        return longestLine;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lines.size(); i++) {
            sb.append("Line ").append(i).append(": length is ").append(lines.get(i).getLength()).append("\n");
        }
        return sb.toString();
    }
}
