package com.shao.progkievua.homework2.lecture08.groupsserialization;

import com.shao.progkievua.homework2.lecture03.NoFreeSpaceInListException;
import com.shao.progkievua.homework2.lecture03.Student;
import com.shao.progkievua.homework2.lecture04.IGroup;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        String dbFile = ".\\src\\com\\shao\\progkievua\\homework2\\lecture08\\groupsserialization\\dbGroups.db";

        Faculty faculty01 = new Faculty(generateFacultyGroups(100));
        faculty01.writeToDB(dbFile);

        Faculty faculty02 = new Faculty();
        faculty02.readAndAddFromDB(dbFile);

        System.out.println(faculty02);
    }

    private static IGroup generateGroup() {
        IGroup group = new IGroup();
        for (int i = 0; i < group.getGroupList().length; i++) {
            try {
                group.addStudent(new Student());
            } catch (NoFreeSpaceInListException e) {
                e.printStackTrace();
            }
        }
        return group;
    }

    private static List<IGroup> generateFacultyGroups(int groupsNumber) {
        List<IGroup> groupsList = new ArrayList<>();
        for (int i = 0; i < groupsNumber; i++) {
            groupsList.add(generateGroup());
        }
        return groupsList;
    }
}
