package com.shao.progkievua.homework.lecture03.Computer;

public class HDD extends FixedMemory implements Memory {
    public HDD(int size) {
        super(size);
    }

    public HDD(int minSize, int maxSize) {
        super(minSize, maxSize);
    }

    public HDD() {
        this(500, 3000);
    }
}
