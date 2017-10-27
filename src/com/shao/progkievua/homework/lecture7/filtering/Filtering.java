package com.shao.progkievua.homework.lecture7.filtering;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Filtering {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("John", 25),
                new Person("Bob", 27),
                new Person("Phil", 22),
                new Person("Jess", 15),
                new Person("Jimm", 17),
                new Person("Doris", 12),
                new Person("Mike", 5),
                new Person("Greg", 7),
                new Person("John", 2),
                new Person("Lisa", 15),
                new Person("George", 17),
                new Person("Patrick", 12)
        );
        List<Person> personsFiltered = new ArrayList<>();

        Collections.sort(persons);
        for (int i = 17; i >= 12; i--) {
            int finalI = i;
            personsFiltered.addAll(persons.stream().filter(person -> person.getAge() == finalI).collect(Collectors.toList()));
        }

        for (Person person : personsFiltered) {
            System.out.println(person);
        }
    }
}