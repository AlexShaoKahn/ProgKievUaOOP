package com.shao.progkievua.courseproject;

public class Event implements Element {
    private long siteId;
    private long showId;
    private long hallId;
    private long eventId;
    private String displaySiteName;
    private String displaySiteAddr;
    private long origin;
    private String widgetUrl;

    public Event(long siteId, long showId, long hallId, long eventId, String displaySiteName, String displaySiteAddr, long origin, String widgetUrl) {
        this.siteId = siteId;
        this.showId = showId;
        this.hallId = hallId;
        this.eventId = eventId;
        this.displaySiteName = displaySiteName;
        this.displaySiteAddr = displaySiteAddr;
        this.origin = origin;
        this.widgetUrl = widgetUrl;
    }

    @Override
    public long getId() {
        return eventId;
    }

    @Override
    public String getUrl() {
        return widgetUrl;
    }

    public long getSiteId() {
        return siteId;
    }

    public long getShowId() {
        return showId;
    }

    public long getHallId() {
        return hallId;
    }

    public String getDisplaySiteName() {
        return displaySiteName;
    }

    public String getDisplaySiteAddr() {
        return displaySiteAddr;
    }

    public long getOrigin() {
        return origin;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("siteId: ")
                .append(siteId)
                .append("\tshowId: ")
                .append(showId)
                .append("\thallId: ")
                .append(hallId)
                .append("\teventId: ")
                .append(eventId)
                .append("\tsiteName: ")
                .append(displaySiteName)
                .append("\tsiteAddr: ")
                .append(displaySiteAddr)
                .append("\ttime: ")
                .append(origin)
                .append("\tURL: ")
                .append(widgetUrl)
                .toString();
    }
}
