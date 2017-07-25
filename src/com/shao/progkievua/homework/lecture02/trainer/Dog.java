package com.shao.progkievua.homework.lecture02.trainer;

import java.util.Random;

public class Dog {
    private final static Random random = new Random();
    private static int dogsIndex = 1;
    private final String name;
    private final int age;

    public Dog(String name, int age) throws IllegalArgumentException {
        if (age <= 0 || age > 15) throw new IllegalArgumentException("wrong age " + age + " must be in 1..15");
        this.name = name;
        this.age = age;
        dogsIndex++;
    }

    public Dog(String name) throws IllegalArgumentException {
        this(name, random.nextInt(15) + 1);
    }

    public Dog(int age) throws IllegalArgumentException {
        this("Dog" + dogsIndex, age);
    }

    public Dog() throws IllegalArgumentException {
        this("Dog" + dogsIndex);
    }

    public void bark() {
        System.out.println(name + " barks!");
    }

    public void bark(int times) {
        System.out.print(name + " barks " + times + " times: ");
        for (int i = 0; i < times; i++) {
            System.out.print("bark");
            if (i < times - 1) System.out.print(", ");
            else System.out.println(".");
        }
    }

    @Override
    public String toString() {
        return "Dog name is " + name + " and age is " + age + ".";
    }
}
