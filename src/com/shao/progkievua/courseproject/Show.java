package com.shao.progkievua.courseproject;

public class Show implements DBListElement {
    private long siteId;
    private long showId;
    private String name;
    private long duration;
    private String orgName;
    private String poster;
    private String description;
    private String widgetUrl;
    private DBList<Event> events;

    public Show(long siteId, long showId, String name, long duration, String orgName, String poster, String description, String widgetUrl, DBList<Event> events) {
        this.siteId = siteId;
        this.showId = showId;
        this.name = name;
        this.duration = duration;
        this.orgName = orgName;
        this.poster = poster;
        this.description = description;
        this.widgetUrl = widgetUrl;
        this.events = events;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Show: ").append(name);
        result.append("\nOrganizer: ").append(orgName);
        if (poster != null && !poster.isEmpty()) result.append("\nPoster: ").append(poster);
        if (events != null) result.append("\n").append(events);
        else result.append("\nNo events");
        return result.toString();
    }

    @Override
    public long getId() {
        return showId;
    }

    @Override
    public String getUrl() {
        return widgetUrl;
    }
}
