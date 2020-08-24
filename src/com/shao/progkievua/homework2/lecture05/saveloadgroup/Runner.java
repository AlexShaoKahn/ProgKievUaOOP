package com.shao.progkievua.homework2.lecture05.saveloadgroup;

import com.shao.progkievua.homework2.lecture03.Gender;
import com.shao.progkievua.homework2.lecture03.NoFreeSpaceInListException;
import com.shao.progkievua.homework2.lecture03.Student;
import com.shao.progkievua.homework2.lecture04.IGroup;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws NoFreeSpaceInListException, IOException {
        String dbFile = ".\\src\\com\\shao\\progkievua\\homework2\\lecture05\\saveloadgroup\\dbGroup.dbg";
        IGroup group = new IGroup();
        GroupDAO groupDAO = new GroupDAO(dbFile);
        group
                .addStudent(new Student()).addStudent(new Student()).addStudent(new Student())
                .addStudent(new Student()).addStudent(new Student()).addStudent(new Student())
                .addStudent(new Student()).addStudent(new Student()).addStudent(new Student());
        group.addStudent(new Student("Gennadiy", "Crocodile", 20, Gender.MALE, Boolean.FALSE));

        groupDAO.saveGroup(group);

        System.out.println(groupDAO.loadGroup(dbFile));

    }
}
