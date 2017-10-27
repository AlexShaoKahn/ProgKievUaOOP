package com.shao.progkievua.homework.lecture7.filtering;

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
        Collections.sort(persons, Collections.reverseOrder());
        persons = persons.stream().filter(person -> person.getAge() >= 12 && person.getAge() <= 17).collect(Collectors.toList());
        for (Person person : persons) {
            System.out.println(person);
        }
    }
}