package com.shao.progkievua.homework.lecture03.Computer;

public class ComputerRunner {
    public static void main(String[] args) {
        Computer computer = new Computer();

        computer.turnOn();
        System.out.println(computer.getLastMessage());
        System.out.println("---------------------------------------");

        System.out.println(computer.toString());
        System.out.println("---------------------------------------");

        computer.checkVirus();
        System.out.println(computer.getLastMessage());
        System.out.println("---------------------------------------");

        computer.cure();
        System.out.println(computer.getLastMessage());
        System.out.println("---------------------------------------");

        computer.turnOff();
        System.out.println(computer.getLastMessage());
    }
}
