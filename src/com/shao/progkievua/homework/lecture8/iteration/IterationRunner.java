package com.shao.progkievua.homework.lecture8.iteration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IterationRunner {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("John", 25),
                new Person("Bob", 27),
                new Person("Phil", 22),
                new Person("Jess", 15),
                new Person("Jimm", 17),
                new Person("Doris", 12),
                new Person("", 5),
                new Person("Greg", 7),
                new Person(null, 2),
                new Person("Lisa", 15),
                new Person("George", 17),
                new Person("Patrick", 12)
        );
        for (Person person : removeNullEmpty(people)) {
            System.out.println(person);
        }
    }

    public static List<Person> removeNullEmpty(List<Person> peopleIn) {
        List<Person> peopleOut = new ArrayList<>();
        peopleOut.addAll(peopleIn);
        Iterator<Person> iterator = peopleOut.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            if (person.getName() == null || person.getName().isEmpty()) iterator.remove();
        }
        return peopleOut;
    }
}
