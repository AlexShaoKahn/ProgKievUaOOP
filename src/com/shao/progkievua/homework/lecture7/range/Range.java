package com.shao.progkievua.homework.lecture7.range;

import com.shao.progkievua.homework.lecture7.pair.Pair;

public class Range<T extends Number & Comparable<T>> {
    Pair<T, T> pair;

    public Range(T lower, T upper) {
        if (upper.compareTo(lower) < 0) throw new IllegalArgumentException("Negative length!");
        this.pair = new Pair<>(lower, upper);
    }
}
