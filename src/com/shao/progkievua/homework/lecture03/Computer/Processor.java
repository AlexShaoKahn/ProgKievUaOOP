package com.shao.progkievua.homework.lecture03.Computer;

import java.util.Random;

public class Processor {
    private double clock = (int) (new Random().nextDouble() * 10) / 10.0 + new Random().nextInt(5);

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + clock + " GHz.";
    }
}
