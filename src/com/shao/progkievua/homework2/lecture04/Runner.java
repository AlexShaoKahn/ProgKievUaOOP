package com.shao.progkievua.homework2.lecture04;

import com.shao.progkievua.homework2.lecture03.NoFreeSpaceInListException;
import com.shao.progkievua.homework2.lecture03.Student;

import java.util.Arrays;
import java.util.Objects;

public class Runner {
    public static void main(String[] args) throws NoFreeSpaceInListException {
        IGroup studentsGroup = new IGroup();

        studentsGroup
                .addStudent(new Student()).addStudent(new Student()).addStudent(new Student()).addStudent(new Student())
                .addStudent(new Student()).addStudent(new Student()).addStudent(new Student()).addStudent(new Student());
        studentsGroup.addStudentInteractively();
        System.out.println(studentsGroup);

        studentsGroup.sortBySurnameReversed();
        System.out.println(studentsGroup);

        System.out.println("Recruits:");
        Arrays.stream(studentsGroup.getRecruitsList()).filter(Objects::nonNull).forEach(System.out::println);

    }
}
