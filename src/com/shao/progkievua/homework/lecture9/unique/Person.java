package com.shao.progkievua.homework.lecture9.unique;

public class Person implements Comparable<Person> {
    private int age;
    private String name;

    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Person person) {
        return name.compareTo(person.name);
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Name: ").append(name).append(", age: ").append(age).toString();
    }
}
