package com.shao.progkievua.homework.lecture04.oopfilesystem;

import java.util.Random;

public final class File extends FSItemPart {
    private final static Random random = new Random();
    private static int counter;

    public File() {
        this(random.nextInt(1000));
    }

    public File(int size) {
        super("file" + (++counter), size);
    }
}
