package com.shao.progkievua.homework.lecture6.film;

public enum Genre {
    ACTION(0, "Action"),
    ADVENTURE(1, "Adventure"),
    COMEDY(2, "Comedy"),
    CRIME(3, "Crime"),
    DRAMA(4, "Drama"),
    HORROR(5, "Horror"),
    MUSICAL(6, "Musical"),
    SCIENCE(7, "Science"),
    WAR(8, "War"),
    WESTERN(9, "Western");

    private final int number;
    private final String description;


    Genre(int number, String description) {
        this.number = number;
        this.description = description;
    }
}
