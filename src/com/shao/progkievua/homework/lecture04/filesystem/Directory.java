package com.shao.progkievua.homework.lecture04.filesystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*Procedural ShitCode*/
@Deprecated
public final class Directory {
    private final static int size = 1;
    private final static Random random = new Random();
    private static int counter;
    private static int dirlevel;
    private String name;
    private List<File> files = new ArrayList<>();
    private List<Directory> dirs = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public Directory() {
        this("dir" + (++counter));
    }

    public Directory(String name, Directory dir, File... files) {
        this(name);
        cycleCheck(dir);
        dirs.add(dir);
        for (File file : files) {
            this.files.add(file);
        }
    }

    public Directory(Directory dir, File... files) {
        this("dir" + (++counter), dir, files);
    }

    public Directory(String name, File... files) {
        this(name);
        for (File file : files) {
            this.files.add(file);
        }
    }

    public Directory(File... files) {
        this("dir" + (++counter), files);
    }

    public Directory add(String name, Directory dir, File... files) {
        cycleCheck(dir);
        dirs.add(dir);
        for (File file : files) {
            this.files.add(file);
        }
        return this;
    }

    public Directory add(Directory dir, File... files) {
        cycleCheck(dir);
        dirs.add(dir);
        for (File file : files) {
            this.files.add(file);
        }
        return this;
    }

    public Directory add(String name, File... files) {
        for (File file : files) {
            this.files.add(file);
        }
        return this;
    }

    public Directory add(File... files) {
        for (File file : files) {
            this.files.add(file);
        }
        return this;
    }

    public int getSize() {
        int size = Directory.size;
        for (File file : files) {
            size += file.getSize();
        }
        for (Directory dir : dirs) {
            size += dir.getSize();
        }
        return size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(spaces("---"));
        result.append(name).append(" (").append(getSize()).append(" B)\n");

        dirlevel++;
        for (Directory dir : dirs) {
            result.append(dir.toString());
        }
        dirlevel--;

        for (File file : files) {
            result.append(spaces("   "));
            result.append(file.toString()).append("\n");
        }
        result.append(spaces("   \n"));

        return result.toString();
    }

    private StringBuilder spaces(String separator) {
        StringBuilder result = new StringBuilder();
        if (dirlevel != 0) {
            result.append("|");
            for (int i = 0; i < dirlevel - 1; i++) {
                result.append("   |");
            }
            result.append(separator);
        }
        return result;
    }

    private void cycleCheck(Directory dir) {
        if (this == dir) throw new IllegalArgumentException("Can't put directory \"" + name + "\" to itself!");
    }
}
