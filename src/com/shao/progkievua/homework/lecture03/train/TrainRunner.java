package com.shao.progkievua.homework.lecture03.train;

public class TrainRunner {
    public static void main(String[] args) {
        TrainCircle train = new TrainCircle();

        System.out.println("Waking up...\nCounting cars...");

        int countedCars = train.countCars();

        System.out.println("We counted " + countedCars + " cars.");
        System.out.println("It is " + train.isLength(countedCars) + "!");
    }
}
