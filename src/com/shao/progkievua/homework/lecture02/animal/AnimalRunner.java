package com.shao.progkievua.homework.lecture02.animal;

class AnimalRunner {
    public static void main(String[] args) {
        Puppy puppy = new Puppy("Roger");

        System.out.print("Puppy's name is ");
        puppy.showName();
        puppy.run();
        puppy.jump();
        puppy.bite();
        puppy.bark();
    }
}
