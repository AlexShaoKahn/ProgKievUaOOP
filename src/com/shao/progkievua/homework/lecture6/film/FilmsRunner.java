package com.shao.progkievua.homework.lecture6.film;

import java.util.Random;

public class FilmsRunner {
    final static String[] ACTORS = {"Arnold Schwarzenegger", "Sylvester Stallone", "Jan Clod Vandam", "Jackie Chan", "Bruce Willis", "Vin Diesel"};

    public static void main(String[] args) {
        Random random = new Random();
        Films films = filmsGenerate();
        int fromYear = 2000;
        int toYear = 2010;
        Actors actors = generateActors();
        Genre genre = Genre.values()[random.nextInt(Genre.values().length)];

        System.out.println("We have " + films.getFilms().size() + " films.\n");
        System.out.println("--------------------------------------------------------");
        System.out.println("Films with actors " + actors);
        System.out.println(films.listBy(actors));
        System.out.println("--------------------------------------------------------");
        System.out.println("Films with genre " + genre.name());
        System.out.println(films.listBy(genre));
        System.out.println("--------------------------------------------------------");
        System.out.println("Films from " + fromYear + " to " + toYear);
        System.out.println(films.listBy(fromYear, toYear));

    }

    private static Films filmsGenerate() {
        Films films = new Films();
        Random random = new Random();
        for (int i = 0; i < random.nextInt(10) + 10; i++) {
            int j = random.nextInt(ACTORS.length);
            Actors actors = generateActors();
            films.addFilm("film" + (random.nextInt(900) + 100), random.nextInt(15) + 1990, actors, Genre.values()[random.nextInt(Genre.values().length)]);
        }
        return films;
    }

    private static Actors generateActors() {
        Random random = new Random();
        int j = random.nextInt(ACTORS.length);
        Actors actors = new Actors(ACTORS[j]);
        j += random.nextInt(3) + 1;
        while (j <= ACTORS.length - 1) {
            actors.addActor(ACTORS[j]);
            j += random.nextInt(3) + 1;
        }
        return actors;
    }
}
