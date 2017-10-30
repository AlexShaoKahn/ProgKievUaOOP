package com.shao.progkievua.courseproject;

import java.io.IOException;

public class CourseProjectRunner {
    public static void main(String[] args) throws IOException {
        DataBase dataBase = new DataBase();
        //dataBase.UpdateDataBase();
        //dataBase.SaveDataBase();
        dataBase.LoadDataBase();
        //System.out.println(dataBase.getSites().list());
        System.out.println(dataBase.getShows().list());
    }
}