package com.shao.progkievua.homework.lecture02.trainer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DogTrainer {
    private final String name;
    private final int age;
    private final List<Dog> dogs;

    public DogTrainer(String name, int age) throws IllegalAccessException {
        if (age <= 0 || age > 125) throw new IllegalAccessException("wrong age:" + age);
        dogs = new ArrayList<>();
        this.name = name;
        this.age = age;
    }

    public DogTrainer(String name) throws IllegalAccessException {
        this(name, new Random().nextInt(50) + 20);
    }


    public void trainDog() throws IllegalAccessException {
        dogs.add(new Dog());
    }


    public void trainDogsPack() throws IllegalAccessException {
        for (int i = 0; i < new Random().nextInt(10) + 2; i++) {
            dogs.add(new Dog());
        }
    }

    public String getDogsPack() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < dogs.size(); i++) {
            result.append((i + 1) + ": " + dogs.get(i).toString()).append("\n");
        }
        return result.toString();
    }

    public void giveCommand(int dogNumber, int times) {
        dogs.get(dogNumber - 1).bark(times);
    }

    public void giveCommand(int times) {
        System.out.println("DogTrainer " + name + " gives a command!");
        for (int i = 0; i < dogs.size(); i++) {
            giveCommand(i - 1, times);
        }
    }

    public void giveCommand() {
        System.out.println("DogTrainer " + name + " gives a command!");
        Random random = new Random();
        for (Dog dog : dogs) {
            dog.bark(random.nextInt(5) + 2);
        }
    }

    @Override
    public String toString() {
        return "DogTrainer's name is " + name + ". He is " + age + " years old. He has " + dogs.size() + " dogs.";
    }
}
