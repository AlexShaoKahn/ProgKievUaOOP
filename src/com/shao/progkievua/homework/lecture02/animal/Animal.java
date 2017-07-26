package com.shao.progkievua.homework.lecture02.animal;

public class Animal {
    public void run() {
        System.out.println(this.getClass().getSimpleName() + " runs.");
    }

    public void jump() {
        System.out.println(this.getClass().getSimpleName() + " jumps.");
    }


}
