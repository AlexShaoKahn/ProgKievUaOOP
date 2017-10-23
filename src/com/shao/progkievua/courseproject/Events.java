package com.shao.progkievua.courseproject;

import java.util.ArrayList;
import java.util.List;

public class Events {
    private List<Event> events = new ArrayList<>();

    public void addEvent(Event event) {
        events.add(event);
    }

    public Event getEvent(long eventId) {
        for (Event event : events) {
            if (event.getId() == eventId) return event;
        }
        return null;
    }
}
