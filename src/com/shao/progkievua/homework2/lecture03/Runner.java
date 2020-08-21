package com.shao.progkievua.homework2.lecture03;

public class Runner {
    public static void main(String[] args) {
        Group group = new Group();
        Student kosyakov = new Student("Kolya", "Kosyakov", 16, Gender.MALE, false);
        try {
            group.addStudent(kosyakov);
            group
                    .addStudent(new Student()).addStudent(new Student()).addStudent(new Student())
                    .addStudent(new Student()).addStudent(new Student()).addStudent(new Student())
                    .addStudent(new Student()).addStudent(new Student()).addStudent(new Student());
            System.out.println(group);
            System.out.println("-------------------------------------------");
            try {
                System.out.println(group.findStudentBySurname("Kosyakov"));
                System.out.println(group.findStudentBySurname("Petrov"));
            } catch (NoStudentFoundException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("\r\n-------------------------------------------");
            group.addStudent(new Student());
        } catch (NoFreeSpaceInListException e) {
            System.out.println(e.getMessage());
        }
        try {
            group.delStudent(kosyakov);
            group.delStudent(new Student());
        } catch (NoStudentFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(group);
    }
}
