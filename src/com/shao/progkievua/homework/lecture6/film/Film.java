package com.shao.progkievua.homework.lecture6.film;

public class Film {
    private String name;
    private int year;
    private Actors actors;
    private Genre genre;

    public Film(String name, int year, Actors actors, Genre genre) {
        this.name = name;
        this.year = year;
        this.actors = actors;
        this.genre = genre;
    }

    public boolean hasActor(Actors actors) {
        for (String actor : actors.getActors()) {
            for (String thisActor : this.actors.getActors()) {
                if (actor.equals(thisActor)) return true;
            }
        }
        return false;
    }

    public boolean hasActor(String actor) {
        for (String thisActor : actors.getActors()) {
            if (thisActor.equals(actor)) return true;
        }
        return false;
    }

    public Genre getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Name: ").append(name)
                .append(", year: ").append(year)
                .append(", genre: ").append(genre)
                .append(", actors: ").append(actors)
                .toString();
    }
}
