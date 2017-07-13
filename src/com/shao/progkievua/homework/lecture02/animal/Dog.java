package com.shao.progkievua.homework.lecture02.animal;

class Dog extends Animal {
    void bite() {
        System.out.println(this.getClass().getSimpleName() + " bites.");
    }
}
