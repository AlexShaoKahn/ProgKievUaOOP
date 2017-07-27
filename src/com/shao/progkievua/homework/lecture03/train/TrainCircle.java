package com.shao.progkievua.homework.lecture03.train;

import java.util.Random;

public class TrainCircle implements Train {
    private TrainCar currentCar;
    private int trainLength = new Random().nextInt(20) + 5;

    public TrainCircle() {
        TrainCar trainCar = new TrainCar();
        currentCar = trainCar;
        for (int i = 1; i < trainLength; i++) {
            trainCar.setLeftCar(new TrainCar());
            trainCar.getLeftCar().setRightCar(trainCar);
            trainCar = trainCar.getLeftCar();
        }
        currentCar.setRightCar(trainCar);
        trainCar.setLeftCar(currentCar);

    }

    public static int findLength(Train train) {
        int countSteps = 0;
        int expectedLength;
        train.lightOn();

        do {
            train.turnLeft();
            countSteps++;
            while (!train.isLightOn()) {
                train.turnLeft();
                countSteps++;
            }
            train.lightOff();
            expectedLength = countSteps;
            for (int i = countSteps; i > 0; i--) {
                train.turnRight();
                countSteps--;
            }
        } while (train.isLightOn());

        return expectedLength;
    }

    @Override
    public void turnLeft() {
        currentCar = currentCar.getLeftCar();
    }

    @Override
    public void turnRight() {
        currentCar = currentCar.getRightCar();
    }

    @Override
    public void lightOn() {
        currentCar.setLamp(true);
    }

    @Override
    public void lightOff() {
        currentCar.setLamp(false);
    }

    @Override
    public boolean isLightOn() {
        return currentCar.isLamp();
    }

    @Override
    public boolean isLength(int expectedLength) {
        return trainLength == expectedLength ? true : false;
    }
}
