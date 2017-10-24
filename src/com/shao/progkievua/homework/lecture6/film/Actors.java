package com.shao.progkievua.homework.lecture6.film;

import java.util.ArrayList;
import java.util.List;

public class Actors {
    private List<String> actors = new ArrayList<>();

    public Actors(String firstActor, String... actors) {
        this.actors.add(firstActor);
        for (String actor : actors) {
            this.actors.add(actor);
        }
    }

    public void addActor(String actor) {
        actors.add(actor);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (String actor : actors) {
            result.append(actor).append(", ");
        }
        return result.substring(0, result.length() - 2);
    }

    public List<String> getActors() {
        return actors;
    }
}
