package com.shao.progkievua.courseproject;

import java.util.ArrayList;
import java.util.List;

public class Shows {
    private List<Show> shows = new ArrayList<>();

    public void addShow(Show show) {
        shows.add(show);
    }

    public Show getShow(long showId) {
        for (Show show : shows) {
            if (show.getId() == showId) return show;
        }
        return null;
    }

    public StringBuilder listShows() {
        StringBuilder result = new StringBuilder();
        for (Show show : shows) {
            result.append(show.toString()).append("--------------------------------------------------\n");
        }
        return result;
    }
}
