package com.shao.progkievua.homework2.lecture01.triangles;

import java.io.Serializable;
import java.util.Objects;
import java.util.Random;

public class Triangle implements Serializable {
    private int sideA;
    private int sideB;
    private int sideC;

    public Triangle() {
        this(generateSides());
    }

    public Triangle(int sideA, int sideB, int sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    private Triangle(int[] sides) {
        this(sides[0], sides[1], sides[2]);
    }

    private static int[] generateSides() {
        Random random = new Random();
        int[] sides = new int[3];
        do {
            sides[0] = random.nextInt(20) + 1;
            sides[1] = random.nextInt(20) + 1;
            sides[2] = random.nextInt(20) + 1;
        } while (sides[0] + sides[1] <= sides[2] || sides[1] + sides[2] <= sides[0] || sides[2] + sides[0] <= sides[1]);
        return sides;
    }

    public Boolean isExist() {
        return sideA + sideB > sideC && sideB + sideC > sideA && sideC + sideA > sideB;
    }

    //Geron's formula
    public double getArea() {
        if (!isExist()) {
            System.out.println("Wrong side length!");
            return -1;
        } else {
            double p = (double) (sideA + sideB + sideC) / 2;
            return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
        }
    }

    public int getSideA() {
        return sideA;
    }

    public int getSideB() {
        return sideB;
    }

    public int getSideC() {
        return sideC;
    }

    public void setSideA(int sideA) {
        this.sideA = sideA;
    }

    public void setSideB(int sideB) {
        this.sideB = sideB;
    }

    public void setSideC(int sideC) {
        this.sideC = sideC;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return sideA == triangle.sideA &&
                sideB == triangle.sideB &&
                sideC == triangle.sideC;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sideA, sideB, sideC);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "sideA=" + sideA +
                ", sideB=" + sideB +
                ", sideC=" + sideC +
                ", area=" + String.format("%.4f", getArea()) +
                '}';
    }


}
