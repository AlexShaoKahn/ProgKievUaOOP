package com.shao.progkievua.homework.lecture04.oopfilesystem;

public abstract class FSItemPart implements FSItem {
    private int size;
    private String name;

    public FSItemPart(String name, int size) {
        this.size = size;
        this.name = name;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (" + size + " B)";
    }

}
