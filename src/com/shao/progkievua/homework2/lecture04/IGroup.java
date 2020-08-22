package com.shao.progkievua.homework2.lecture04;

import com.shao.progkievua.homework2.lecture03.Gender;
import com.shao.progkievua.homework2.lecture03.Group;
import com.shao.progkievua.homework2.lecture03.Student;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class IGroup extends Group implements MilitaryCommissar, Serializable {
    public IGroup() {
    }

    class ByName implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            if (o1 == null || o2 == null) return 0;
            if (o1 == null) return -1;
            if (o2 == null) return 1;
            return o1.getName().compareToIgnoreCase(o2.getName());
        }
    }

    class BySurname implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            if (o1 == null || o2 == null) return 0;
            if (o1 == null) return -1;
            if (o2 == null) return 1;
            return o1.getSurname().compareToIgnoreCase(o2.getSurname());
        }
    }

    class ByAge implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            if (o1 == null || o2 == null) return 0;
            if (o1 == null) return -1;
            if (o2 == null) return 1;
            return Integer.compare(o1.getAge(), o2.getAge());
        }
    }

    class ByGender implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            if (o1 == null || o2 == null) return 0;
            if (o1 == null) return -1;
            if (o2 == null) return 1;
            return o1.getGender().compareTo(o2.getGender());
        }
    }

    @Override
    public Student[] getRecruitsList() {
        Student[] recruitsList = new Student[groupList.length];
        int i = 0;
        for (Student student : groupList)
            if (student != null && student.getGender() != Gender.FEMALE && student.getAge() > 18)
                recruitsList[i++] = student;

        return recruitsList;
    }

    public void sortByAgeAndGender() {
        Arrays.sort(groupList, new ByAge().thenComparing(new ByGender()));
    }

    public void sortBySurname() {
        Arrays.sort(groupList, new BySurname());
    }

    public void sortByName() {
        Arrays.sort(groupList, new ByName());
    }

    public void sortByAge() {
        Arrays.sort(groupList, new ByAge());
    }

    public void sortByAgeAndGenderReversed() {
        Arrays.sort(groupList, new ByAge().thenComparing(new ByGender().reversed()).reversed());
    }

    public void sortBySurnameReversed() {
        Arrays.sort(groupList, new BySurname().reversed());
    }

    public void sortByNameReversed() {
        Arrays.sort(groupList, new ByName().reversed());
    }

    public void sortByAgeReversed() {
        Arrays.sort(groupList, new ByAge().reversed());
    }

    public void addStudentInteractively() {
        Scanner scanner = new Scanner(System.in);
        String studentName;
        String studentSurname;
        int studentAge;
        Gender studentGender;
        boolean studentLivesInDorms;
        System.out.println("Enter in one line divided by SPACE name, surname, age, gender and if student live in dormitories.");
        System.out.println("Example 1: Joe Goodman 18 male false");
        System.out.println("Example 2: Amanda Flores 22 female true");
        System.out.println("Enter student data or enter 'auto' for autofill");

        for (; ; ) {
            try {
                String[] studentInfo = scanner.nextLine().split(" ");
                if (studentInfo.length == 1 && studentInfo[0].equalsIgnoreCase("auto")) addStudent(new Student());
                else {
                    studentName = studentInfo[0];
                    studentSurname = studentInfo[1];
                    studentAge = Integer.parseInt(studentInfo[2]);
                    studentGender = Gender.valueOf(studentInfo[3].toUpperCase());
                    studentLivesInDorms = Boolean.getBoolean(studentInfo[4].toUpperCase());
                    addStudent(new Student(studentName, studentSurname, studentAge, studentGender, studentLivesInDorms));
                }
                break;
            } catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage() + "! Try again!");
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder().append("Group List").append(System.lineSeparator());
        for (Student student : groupList) {
            if (student != null) result.append(student.toString()).append(System.lineSeparator());
        }
        return result.toString();
    }


}
