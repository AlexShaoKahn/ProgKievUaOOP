package com.shao.progkievua.homework2.lecture07.ships;

public class Runner {
    public static void main(String[] args) {
        Port port = new Port(3);
        port.openPort();
        port.unloadFleet(generateFleet(5));
        port.closePort();
    }

    private static Ship[] generateFleet(int shipsNumber) {
        Ship[] ships = new Ship[shipsNumber];
        for (int i = 0; i < ships.length; i++) {
            ships[i] = new Ship();
        }
        return ships;
    }
}
