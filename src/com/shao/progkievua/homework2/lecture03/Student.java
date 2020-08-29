package com.shao.progkievua.homework2.lecture03;

import java.io.Serializable;
import java.util.Objects;
import java.util.Random;

public class Student extends Human implements Serializable, Comparable<Student> {
    private static final long serialVersionUID = 1469629162319286204L;
    private boolean livesInDormitory;

    public Student() {
        super();
        livesInDormitory = new Random().nextBoolean();
    }

    public Student(String name, String surname, int age, Gender gender, boolean livesInDormitory) {
        super(name, surname, age, gender);
        this.livesInDormitory = livesInDormitory;
    }

    public boolean isLivesInDormitory() {
        return livesInDormitory;
    }

    public void setLivesInDormitory(boolean livesInDormitory) {
        this.livesInDormitory = livesInDormitory;
    }

    @Override
    public String toString() {
        return "Student " + super.toString() + ", lives in dorms: " + (livesInDormitory ? "yes" : "no");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return livesInDormitory == student.livesInDormitory;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), livesInDormitory);
    }

    @Override
    public int compareTo(Student o) {
        if (o == null) return 0;
        return getSurname().compareTo(o.getSurname());
    }
}
