package com.shao.progkievua.homework.lecture03.train;

import java.util.Random;

public class TrainCar {
    private boolean lamp = new Random().nextBoolean();
    private TrainCar leftCar;
    private TrainCar rightCar;

    public TrainCar getLeftCar() {
        return leftCar;
    }

    public void setLeftCar(TrainCar leftCar) {
        this.leftCar = leftCar;
    }

    public TrainCar getRightCar() {
        return rightCar;
    }

    public void setRightCar(TrainCar rightCar) {
        this.rightCar = rightCar;
    }

    public boolean isLamp() {
        return lamp;
    }

    public void setLamp(boolean lamp) {
        this.lamp = lamp;
    }
}
