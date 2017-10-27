package com.shao.progkievua.homework.lecture7.filtering;

public class Person implements Comparable<Person> {
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

    @Override
    public int compareTo(Person person) {
        return name.compareTo(person.name);
    }
}
