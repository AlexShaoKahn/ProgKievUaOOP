package com.shao.progkievua.courseproject;

public class Site implements DBListElement {
    private long siteId;
    private String name;
    private String widgetUrl;

    public Site(long siteId, String name, String widgetUrl) {
        this.siteId = siteId;
        this.name = name;
        this.widgetUrl = widgetUrl;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("ID: ").append(siteId)
                .append(", SITE: ").append(name)
                .append(", URL: ").append(widgetUrl)
                .toString();
    }

    @Override
    public long getId() {
        return siteId;
    }

    @Override
    public String getUrl() {
        return widgetUrl;
    }
}
