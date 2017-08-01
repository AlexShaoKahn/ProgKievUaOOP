package com.shao.progkievua.homework.lecture04.filesystem;

import java.util.Random;

public final class File {
    private final static Random random = new Random();
    private static int counter;
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public File(String name) {
        this(name, random.nextInt(1000));
    }

    public File(int size) {
        this("f" + (++counter), size);
    }

    public File() {
        this("f" + (++counter), random.nextInt(1000));
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "|---" + name + " (" + size + " B)";
    }
}
