package com.shao.progkievua.homework2.lecture07.ships;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Port {
    private int dockSpace;
    private ExecutorService executor;

    public Port() {
        this(2);
    }

    public Port(int dockSpace) {
        this.dockSpace = dockSpace;
    }

    public void unloadShip(Ship ship) {
        if (ifPortOpened()) executor.submit(ship);
    }

    public void unloadFleet(Ship[] ships) {
        if (ifPortOpened()) for (Ship ship : ships) {
            unloadShip(ship);
        }
    }

    public void closePort() {
        if (ifPortOpened()) executor.shutdown();
    }

    public void openPort() {
        if (!ifPortOpened()) executor = Executors.newFixedThreadPool(dockSpace);
    }

    private boolean ifPortOpened() {
        return executor != null && !executor.isShutdown() && !executor.isTerminated();
    }
}
