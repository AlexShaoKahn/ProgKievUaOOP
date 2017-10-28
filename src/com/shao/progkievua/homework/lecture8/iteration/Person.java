package com.shao.progkievua.homework.lecture8.iteration;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Name: ").append(name).append(", age: ").append(age).toString();
    }
}
