package com.shao.progkievua.homework2.lecture09.groupmod;

import com.shao.progkievua.homework2.lecture03.NoFreeSpaceInListException;
import com.shao.progkievua.homework2.lecture03.Student;

public class Runner {
    public static void main(String[] args) {
        MGroup studentsGroup = new MGroup();

        try {
            studentsGroup
                    .addStudent(new Student()).addStudent(new Student()).addStudent(new Student()).addStudent(new Student())
                    .addStudent(new Student()).addStudent(new Student()).addStudent(new Student()).addStudent(new Student());
            studentsGroup.addStudentInteractively();
        } catch (NoFreeSpaceInListException e) {
            e.printStackTrace();
        }
        System.out.println(studentsGroup);

        studentsGroup.sortBySurnameReversed();
        System.out.println(studentsGroup);

        System.out.println("Recruits:");
        for (Student student : studentsGroup.getRealRecruitsList()) {
            System.out.println(student);
        }
    }
}
