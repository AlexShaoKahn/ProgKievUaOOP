package com.shao.progkievua.homework2.lecture01.cat;

import java.io.Serializable;
import java.util.Objects;
import java.util.Random;

public class Cat implements Serializable {
    private String name;
    private Color color;
    private int weight;

    public Cat() {
    }

    public Cat(String name) {
        this.name = name;
        color = Color.values()[new Random().nextInt(Color.values().length)];
        weight = new Random().nextInt(10) + 1;
    }

    public void voice() {
        System.out.println(this.getClass().getSimpleName() + " " + name + " says: \"meow!\"");
    }

    public void starve() {
        weight = weight > 1 ? weight - 1 : 1;
    }

    public void feed() {
        weight++;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return weight == cat.weight &&
                Objects.equals(name, cat.name) &&
                color == cat.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, color, weight);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", colour='" + color.name() + '\'' +
                ", weight=" + weight +
                '}';
    }
}
