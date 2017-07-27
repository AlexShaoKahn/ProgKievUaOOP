package com.shao.progkievua.homework.lecture03.Computer;

import java.util.Random;

public class FDD implements Memory {
    private static Random random = new Random();
    private boolean diskInserted = random.nextBoolean();
    private boolean infected = random.nextBoolean();
    private int size;
    private String name = this.getClass().getSimpleName();

    public FDD(int size) {
        if (diskInserted) this.size = size;
        else size = 0;
    }

    public FDD(int minSize, int maxSize) {
        if (diskInserted) this.size = random.nextInt(maxSize - minSize) + minSize;
        else size = 0;
    }

    public FDD() {
        this(1200, 4700);
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        if (diskInserted) return size;
        else return -1;
    }

    public boolean isInfected() {
        return infected;
    }

    public void setInfected(boolean infected) {
        this.infected = infected;
    }

    public boolean isDiskInserted() {
        return diskInserted;
    }

    @Override
    public String toString() {
        if (diskInserted) return this.getClass().getSimpleName() + ": " + getSize() + " GB.";
        else return this.getClass().getSimpleName() + ": no disk inside!";
    }
}
