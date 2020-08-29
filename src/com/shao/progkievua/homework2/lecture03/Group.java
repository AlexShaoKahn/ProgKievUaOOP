package com.shao.progkievua.homework2.lecture03;

import java.io.Serializable;
import java.util.Arrays;

public class Group implements Serializable {
    private static final long serialVersionUID = -7358805781579731187L;
    protected Student[] groupList = new Student[10];

    public Group() {
    }

    private Group(Student[] groupList) {
        this.groupList = groupList.clone();
    }

    public Group addStudent(Student student) throws NoFreeSpaceInListException {
        int index = 0;
        while (index < groupList.length && groupList[index] != null) index++;
        if (index >= groupList.length) throw new NoFreeSpaceInListException();
        else groupList[index] = student;
        return this;
    }

    public void delStudent(Student student) throws NoStudentFoundException {
        boolean done = Boolean.FALSE;
        for (int i = 0; i < groupList.length; i++) {
            if (groupList[i] != null && groupList[i].equals(student)) {
                groupList[i] = null;
                done = Boolean.TRUE;
            }
        }
        if (!done) throw new NoStudentFoundException();
    }

    public Student findStudentBySurname(String surname) throws NoStudentFoundException {
        for (Student student : groupList) {
            if (student != null && student.getSurname().equals(surname)) return student;
        }
        throw new NoStudentFoundException();
    }

    public Student[] getGroupList() {
        return groupList.clone();
    }

    public Group setGroupList(Student[] groupList) {
        return new Group(groupList.clone());
    }

    private void sortBySurname() {
        Student temp;
        for (int i = 0; i < groupList.length - 1; i++) {
            for (int j = i; j < groupList.length; j++) {
                if (groupList[i] != null && groupList[i].compareTo(groupList[j]) > 0) {
                    temp = groupList[i];
                    groupList[i] = groupList[j];
                    groupList[j] = temp;
                }
            }
        }
    }

    @Override
    public String toString() {
        sortBySurname();
        StringBuilder result = new StringBuilder().append("Group List").append(System.lineSeparator());
        for (Student student : groupList) {
            if (student != null) result.append(student.toString()).append(System.lineSeparator());
        }
        return result.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group)) return false;
        Group group = (Group) o;
        return Arrays.equals(groupList, group.groupList);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(groupList);
    }
}
