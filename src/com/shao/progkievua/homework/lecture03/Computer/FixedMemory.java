package com.shao.progkievua.homework.lecture03.Computer;

import java.util.Random;

public abstract class FixedMemory {
    private Random random = new Random();
    private boolean infected = random.nextBoolean();
    private int size;
    private String name = this.getClass().getSimpleName();

    public FixedMemory(int size) {
        this.size = size;
    }

    public FixedMemory(int minSize, int maxSize) {
        this.size = random.nextInt(maxSize - minSize) + minSize;
        name = this.getClass().getSimpleName();
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public boolean isInfected() {
        return infected;
    }

    public void setInfected(boolean infected) {
        this.infected = infected;
    }

    public Random getRandom() {
        return random;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + getSize() + " GB.";
    }
}
