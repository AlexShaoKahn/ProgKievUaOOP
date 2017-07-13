package com.shao.progkievua.homework.lecture02.immutable;

import java.util.ArrayList;

class Lines {
    private ArrayList<Line> lines;

    Lines() {
        lines = new ArrayList<>();
    }

    void add(Line line) {
        lines.add(line);
    }

    double sumLength() {
        double summ = 0;
        for (Line line : lines) {
            summ += line.getLength();
        }
        return summ;
    }

    Line longestLine() {
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
}
