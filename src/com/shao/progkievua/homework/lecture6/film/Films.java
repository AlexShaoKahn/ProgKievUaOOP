package com.shao.progkievua.homework.lecture6.film;

import java.util.ArrayList;
import java.util.List;

public class Films {
    private List<Film> films = new ArrayList<>();

    public void addFilm(String name, int year, Actors actors, Genre genre) {
        films.add(new Film(name, year, actors, genre));
    }

    public void addFilm(Film film) {
        films.add(film);
    }

    public Films listBy(Genre genre) {
        Films films = new Films();
        for (Film film : this.films) {
            if (film.getGenre().equals(genre)) films.addFilm(film);
        }
        return films;
    }

    public Films listBy(Actors actors) {
        Films films = new Films();
        for (Film film : this.films) {
            if (film.hasActor(actors)) films.addFilm(film);
        }
        return films;
    }

    public Films listBy(String actor) {
        Films films = new Films();
        for (Film film : this.films) {
            if (film.hasActor(actor)) films.addFilm(film);
        }
        return films;
    }

    public Films listBy(int year) {
        Films films = new Films();
        for (Film film : this.films) {
            if (year == film.getYear()) films.addFilm(film);
        }
        return films;
    }

    public Films listBy(int fromYear, int toYear) {
        Films films = new Films();
        for (Film film : this.films) {
            if (film.getYear() >= fromYear && film.getYear() <= toYear) films.addFilm(film);
        }
        return films;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        if (films.size() == 0) return "No films\n";
        for (Film film : films) {
            result.append(film).append("\n");
        }
        return result.toString();
    }

    public List<Film> getFilms() {
        return films;
    }
}
