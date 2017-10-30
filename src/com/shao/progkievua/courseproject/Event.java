package com.shao.progkievua.courseproject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event implements DBListElement {
    private long siteId;
    private long showId;
    private long hallId;
    private long eventId;
    private String displaySiteName;
    private String displaySiteAddr;
    private String origin;
    private String widgetUrl;
    private LocalDateTime date;

    public Event(long siteId, long showId, long hallId, long eventId, String displaySiteName, String displaySiteAddr, String origin, String widgetUrl) {
        this.siteId = siteId;
        this.showId = showId;
        this.hallId = hallId;
        this.eventId = eventId;
        this.displaySiteName = displaySiteName;
        this.displaySiteAddr = displaySiteAddr;
        this.origin = origin;
        this.widgetUrl = widgetUrl;
        this.date = parseDate(origin);
    }

    private LocalDateTime parseDate(String origin) {
        int year = Integer.parseInt(origin.substring(0, 4));
        int month = Integer.parseInt(origin.substring(4, 6));
        int day = Integer.parseInt(origin.substring(6, 8));
        int hours = Integer.parseInt(origin.substring(8, 10));
        int minutes = Integer.parseInt(origin.substring(10, 12));
        int seconds = Integer.parseInt(origin.substring(12, 14));
        return LocalDateTime.of(year, month, day, hours, minutes, seconds);
    }

    private String dateToString(LocalDateTime date) {
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Site: ").append(displaySiteName);
        if (displaySiteAddr != null && !displaySiteAddr.isEmpty())
            result.append("\nAddress: ").append(displaySiteAddr);
        result.append("\nDate: ").append(dateToString(parseDate(origin)));
        result.append("\nBuy URL: ").append(widgetUrl);
        result.append("\n---------------------------------------------------");
        return result.toString();
    }

    @Override
    public long getId() {
        return eventId;
    }

    @Override
    public String getUrl() {
        return widgetUrl;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
