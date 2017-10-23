package com.shao.progkievua.courseproject;

import java.io.IOException;

public class CourseProjectRunner {
    public static void main(String[] args) throws IOException {
        DataBase dataBase = new DataBase();
        System.out.println(dataBase.getSites().listSites());
        //System.out.println(dataBase.getShows().listShows());
    }
}