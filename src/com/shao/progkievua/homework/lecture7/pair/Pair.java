package com.shao.progkievua.homework.lecture7.pair;

public class Pair<L, R> {
    private final L left;
    private final R right;

    public Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(right).append(" : ").append(left).toString();
    }
}
