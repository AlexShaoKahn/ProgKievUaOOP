package com.shao.progkievua.homework.lecture04.oopfilesystem;

public class FSRunner {
    public static void main(String[] args) {
        Directory root = new Directory("root");

        Directory d1 = new Directory(
                new File(10),
                new File(10),
                new Symlink(root)
        );

        Directory d2 = new Directory(
                new Directory(
                        new File(30)
                ),
                new File(40)
        );

        root.add(d1).add(d2).add(new File(50)).add(new Symlink(d2));

        System.out.println(root.toString());
        System.out.println("Root size: " + root.getSize());
    }
}
