package com.shao.progkievua.homework2.lecture07.ships;

import java.util.Random;

public class Ship implements Runnable {
    private String name;
    private int crates;

    public Ship() {
        this("Ship " + new Random().nextInt(100000), 10);
    }

    public Ship(String name, int crates) {
        this.crates = crates;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCrates() {
        return crates;
    }

    @Override
    public void run() {
        while (crates > 0) {
            try {
                unloadCrate();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }

    private void unloadCrate() throws InterruptedException {
        System.out.println("Ship \"" + name + "\" unloaded crate #" + crates);
        crates--;
        if (crates == 0) System.out.println("Ship \"" + name + "\" fully unloaded");
        Thread.sleep(500);
    }
}
