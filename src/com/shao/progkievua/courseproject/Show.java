package com.shao.progkievua.courseproject;

public class Show implements Element {
    private long siteId;
    private long showId;
    private String name;
    private long duration;
    private String orgName;
    private String poster;
    private String description;
    private String widgetUrl;
    private Events events;

    public Show(long siteId, long showId, String name, long duration, String orgName, String poster, String description, String widgetUrl, Events events) {
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
    public long getId() {
        return showId;
    }

    @Override
    public String getUrl() {
        return widgetUrl;
    }


    public long getSiteId() {
        return siteId;
    }

    public String getName() {
        return name;
    }

    public long getDuration() {
        return duration;
    }

    public String getOrgName() {
        return orgName;
    }

    public String getPoster() {
        return poster;
    }

    public String getDescription() {
        return description;
    }

    public Events getEvents() {
        return events;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder()
                .append("siteId: ").append(siteId)
                .append("\nshowId: ").append(showId)
                .append("\nname: ").append(name)
                .append("\nduration: ").append(duration)
                .append("\norgName: ").append(orgName)
                .append("\nposter: ").append(poster)
                .append("\ndescription: ").append(description)
                .append("\nURL: ").append(widgetUrl);
        if (events != null) result.append(events.toString());
        else result.append("\nNo events");
        result.append("\n");
        result.toString();
        return result.toString();
    }
}
