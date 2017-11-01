package com.shao.progkievua.homework.lecture9.unique;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class UniqueSortedPeople {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("John", 25),
                new Person("John", 25),
                new Person("Bob", 27),
                new Person("Bob", 27),
                new Person("Phil", 22),
                new Person("Jess", 15),
                new Person("Jess", 15),
                new Person("Jimm", 17),
                new Person("Jimm", 17),
                new Person("Doris", 12),
                new Person("Greg", 7),
                new Person("Greg", 7),
                new Person("Lisa", 15),
                new Person("George", 17),
                new Person("George", 17),
                new Person("Patrick", 12)
        );

        Set<Person> uniquePeople = new TreeSet<>(people);

        for (Person uniquePerson : uniquePeople) {
            System.out.println(uniquePerson);
        }
    }
}
