package com.shao.progkievua.homework.lecture02.animal;

abstract class Animal {
    void run() {
        System.out.println(this.getClass().getSimpleName() + " runs.");
    }

    void jump() {
        System.out.println(this.getClass().getSimpleName() + " jumps.");
    }


}
