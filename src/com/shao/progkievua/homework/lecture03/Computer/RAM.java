package com.shao.progkievua.homework.lecture03.Computer;

public class RAM extends FixedMemory implements Memory {
    public RAM(int size) {
        super(size);
    }

    public RAM(int minSize, int maxSize) {
        super(minSize, maxSize);
    }

    public RAM() {
        this(2, 16);
    }
}
