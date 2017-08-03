package com.shao.progkievua.homework.lecture04.oopfilesystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Directory extends FSItemPart {
    private final static Random random = new Random();
    private static int counter;
    private static int dirlevel;
    private final List<FSItem> fsItems = new ArrayList<>();

    public Directory() {
        super("dir" + (++counter), 0);
    }

    public Directory(String name) {
        super(name, 0);
    }

    public Directory(FSItem... fsItems) {
        this();
        for (FSItem fsItem : fsItems) {
            cycleCheck(fsItem);
            this.fsItems.add(fsItem);
        }
    }

    public Directory add(FSItem... fsItems) {
        for (FSItem fsItem : fsItems) {
            cycleCheck(fsItem);
            this.fsItems.add(fsItem);
        }
        return this;
    }

    @Override
    public int getSize() {
        int size = super.getSize();
        for (FSItem fsItem : fsItems) {
            size += fsItem.getSize();
        }
        return size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        dirlevel++;
        result.append(getName()).append("\n");
        for (FSItem fsItem : fsItems) {
            result
                    .append(spaces("|   "))
                    .append("|---")
                    .append(fsItem.toString())
                    .append("\n");
        }
        result.append(spaces("|   "));
        dirlevel--;

        return result.toString();
    }

    private StringBuilder spaces(String separator) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < dirlevel - 1; i++) {
            result.append(separator);
        }
        return result;
    }

    private void cycleCheck(FSItem fsItem) {
        if (this == fsItem) throw new IllegalArgumentException("Can't put directory \"" + getName() + "\" to itself!");
    }
}
