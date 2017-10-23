package com.shao.progkievua.courseproject;

public class Site implements Element {
    private long siteId;
    private String name;
    private String widgetUrl;

    public Site(long siteId, String name, String widgetUrl) {
        this.siteId = siteId;
        this.name = name;
        this.widgetUrl = widgetUrl;
    }

    @Override
    public long getId() {
        return siteId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getUrl() {
        return widgetUrl;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("siteId: ")
                .append(siteId)
                .append("\tname: ")
                .append(name)
                .append("\tURL: ")
                .append(widgetUrl)
                .toString();
    }
}
