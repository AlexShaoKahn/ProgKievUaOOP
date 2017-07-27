package com.shao.progkievua.homework.lecture03.Computer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Computer {
    private static String lastMessage;
    private final Processor processor;
    private final List<Memory> memory;
    private boolean turnedOn = false;


    public Computer() {
        processor = new Processor();
        memory = new ArrayList<>();
        memory.add(new HDD());
        memory.add(new RAM());
        memory.add(new FDD());
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void turnOn() {
        if (!turnedOn) {
            turnedOn = true;
            lastMessage = "Computer was turned on!";
        } else {
            lastMessage = "Computer is turned on already!";
        }
    }

    public void turnOff() {
        if (turnedOn) {
            turnedOn = false;
            lastMessage = "Computer was turned off!";
        } else {
            lastMessage = "Computer is turned off already!";
        }
    }

    public void checkVirus() {
        StringBuilder message = new StringBuilder().append("Virus check:\n");
        for (Memory m : memory) {
            if (!(m instanceof FixedMemory) && (!((FDD) m).isDiskInserted()))
                message.append(m.getName() + ": no disk inside!");
            else {
                message.append(m.getName()).append(": virus");
                if (!m.isInfected()) message.append(" not");
                message.append(" found!");
            }
            message.append("\n");
        }
        lastMessage = message.substring(0, message.length() - 1);
    }

    public void cure() {
        StringBuilder message = new StringBuilder().append("Treatment:\n");
        for (Memory m : memory) {
            message.append(m.getName()).append(": ");
            if (!(m instanceof FixedMemory) && (!((FDD) m).isDiskInserted()))
                message.append("no disk inside!");
            else if (m.isInfected()) {
                m.setInfected(false);
                message.append("virus deleted!");
            } else message.append("nothing to cure.");
            message.append("\n");
        }
        lastMessage = message.substring(0, message.length() - 1);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(processor.toString()).append("\n");
        for (Memory m : memory) {
            result.append(m.toString()).append("\n");
        }
        return result.substring(0, result.length() - 1);
    }
}
