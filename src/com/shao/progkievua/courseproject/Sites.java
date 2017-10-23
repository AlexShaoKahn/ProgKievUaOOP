package com.shao.progkievua.courseproject;

import java.util.ArrayList;
import java.util.List;

public class Sites {
    private List<Site> sites = new ArrayList<>();

    public void addSite(Site site) {
        sites.add(site);
    }

    public Site getSite(long siteId) {
        for (Site site : sites) {
            if (site.getId() == siteId) return site;
        }
        return null;
    }

    public StringBuilder listSites() {
        StringBuilder result = new StringBuilder();
        for (Site site : sites) {
            result.append(site.toString()).append("\n");
        }
        return result;
    }
}
