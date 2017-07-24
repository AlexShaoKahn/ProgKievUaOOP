package com.shao.progkievua.homework.lecture02.trainer;

public class TrainerRunner {
    public static void main(String[] args) throws IllegalAccessException {
        DogTrainer dogTrainer = new DogTrainer("Jack");
        dogTrainer.trainDogsPack();

        System.out.println(dogTrainer.toString());
        System.out.println(dogTrainer.getDogsPack());
        dogTrainer.giveCommand();
    }
}
