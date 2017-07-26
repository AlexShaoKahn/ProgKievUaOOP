package com.shao.progkievua.homework.lecture02.animal;

public class Puppy extends Dog {
    private String name;

    public Puppy(String name) {
        this.name = name;
    }

    public void bark() {
        System.out.println(this.getClass().getSimpleName() + " barks.");
    }

    public void showName() {
        System.out.println(name);
    }
}
