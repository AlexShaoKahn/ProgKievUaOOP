package com.shao.progkievua.homework.lecture02.animal;

public class Dog extends Animal {
    public void bite() {
        System.out.println(this.getClass().getSimpleName() + " bites.");
    }
}
