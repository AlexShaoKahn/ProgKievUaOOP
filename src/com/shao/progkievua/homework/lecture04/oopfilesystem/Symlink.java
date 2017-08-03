package com.shao.progkievua.homework.lecture04.oopfilesystem;

import java.util.Random;

public class Symlink extends FSItemPart {
    private final static Random random = new Random();
    private static int counter;
    private FSItem link;

    public Symlink(String name, FSItem fsItem) {
        super(name, 1);
        link = fsItem;
    }

    public Symlink(FSItem fsItem) {
        this("link" + (++counter), fsItem);
    }
}
