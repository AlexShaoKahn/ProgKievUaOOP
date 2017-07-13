package com.shao.progkievua.homework.lecture02.animal;

class Puppy extends Dog {
    private String name;

    Puppy(String name) {
        this.name = name;
    }

    void bark() {
        System.out.println(this.getClass().getSimpleName() + " barks.");
    }

    void showName() {
        System.out.println(name);
    }
}
