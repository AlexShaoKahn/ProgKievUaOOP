package com.shao.progkievua.homework2.lecture09.groupmod;

import com.shao.progkievua.homework2.lecture03.*;
import com.shao.progkievua.homework2.lecture04.IGroup;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class MGroup extends IGroup implements Serializable {
    private static final long serialVersionUID = -7016204345364378361L;
    protected List<Student> groupLst = new ArrayList<>();

    public MGroup() {
    }


    @Override
    public Group addStudent(Student student) throws NoFreeSpaceInListException {
        if (groupLst.size() >= super.getGroupList().length) throw new NoFreeSpaceInListException();
        groupLst.add(student);
        return this;
    }

    @Override
    public void delStudent(Student student) throws NoStudentFoundException {
        if (!groupLst.contains(student)) throw new NoStudentFoundException();
        else groupLst.remove(student);
    }

    @Override
    public Student findStudentBySurname(String surname) throws NoStudentFoundException {
        for (Student student : groupLst) {
            if (student.getSurname().equals(surname)) return student;
        }
        throw new NoStudentFoundException();
    }

    public List<Student> getRealRecruitsList() {
        List<Student> recruits = new ArrayList<>();
        for (Student student : groupLst) {
            if (student != null && student.getGender() != Gender.FEMALE && student.getAge() > 18) recruits.add(student);
        }
        return recruits;
    }

    @Override
    public void sortBySurnameReversed() {
        groupLst.sort(((Comparator<Student>) (o1, o2) -> {
            if (o1 == null || o2 == null) return 0;
            if (o1 == null) return -1;
            if (o2 == null) return 1;
            return o1.getSurname().compareToIgnoreCase(o2.getSurname());
        }).reversed());
    }

    @Override
    public void sortByAgeAndGender() {
        groupLst.sort(((Comparator<Student>) (o1, o2) -> {
            if (o1 == null || o2 == null) return 0;
            if (o1 == null) return -1;
            if (o2 == null) return 1;
            return Integer.compare(o1.getAge(), o2.getAge());
        }).thenComparing((o1, o2) -> {
            if (o1 == null || o2 == null) return 0;
            if (o1 == null) return -1;
            if (o2 == null) return 1;
            return o1.getGender().compareTo(o2.getGender());
        }));
    }

    @Override
    public void sortBySurname() {
        groupLst.sort((o1, o2) -> {
            if (o1 == null || o2 == null) return 0;
            if (o1 == null) return -1;
            if (o2 == null) return 1;
            return o1.getSurname().compareToIgnoreCase(o2.getSurname());
        });
    }

    @Override
    public void sortByName() {
        groupLst.sort((o1, o2) -> {
            if (o1 == null || o2 == null) return 0;
            if (o1 == null) return -1;
            if (o2 == null) return 1;
            return o1.getName().compareToIgnoreCase(o2.getName());
        });
    }

    @Override
    public void sortByAge() {
        groupLst.sort(((Comparator<Student>) (o1, o2) -> {
            if (o1 == null || o2 == null) return 0;
            if (o1 == null) return -1;
            if (o2 == null) return 1;
            return Integer.compare(o2.getAge(), o1.getAge());
        }).reversed());
    }

    @Override
    public void sortByAgeAndGenderReversed() {
        groupLst.sort(((Comparator<Student>) (o1, o2) -> {
            if (o1 == null || o2 == null) return 0;
            if (o1 == null) return -1;
            if (o2 == null) return 1;
            return Integer.compare(o1.getAge(), o2.getAge());
        }).thenComparing((o1, o2) -> {
            if (o1 == null || o2 == null) return 0;
            if (o1 == null) return -1;
            if (o2 == null) return 1;
            return o1.getGender().compareTo(o2.getGender());
        }).reversed());
    }

    @Override
    public void sortByNameReversed() {
        groupLst.sort(((Comparator<Student>) (o1, o2) -> {
            if (o1 == null || o2 == null) return 0;
            if (o1 == null) return -1;
            if (o2 == null) return 1;
            return o1.getName().compareToIgnoreCase(o2.getName());
        }).reversed());
    }

    @Override
    public void sortByAgeReversed() {
        groupLst.sort((o1, o2) -> {
            if (o1 == null || o2 == null) return 0;
            if (o1 == null) return -1;
            if (o2 == null) return 1;
            return Integer.compare(o1.getAge(), o2.getAge());
        });
    }

    public List<Student> getRealGroupList() {
        return groupLst;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder().append("Group List").append(System.lineSeparator());
        for (Student student : groupLst) {
            result.append(student.toString()).append(System.lineSeparator());
        }
        return result.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MGroup)) return false;
        if (!super.equals(o)) return false;
        MGroup mGroup = (MGroup) o;
        return groupLst.equals(mGroup.groupLst);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), groupLst);
    }
}
