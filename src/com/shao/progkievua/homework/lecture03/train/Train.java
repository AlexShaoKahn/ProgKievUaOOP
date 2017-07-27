package com.shao.progkievua.homework.lecture03.train;

/**
 * @author Bohdan Vanchuhov
 */
public interface Train {
    void turnLeft();

    void turnRight();

    void lightOn();

    void lightOff();

    boolean isLightOn();

    boolean isLength(int expectedLength);
}
