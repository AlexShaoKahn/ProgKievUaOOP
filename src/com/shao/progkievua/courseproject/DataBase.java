package com.shao.progkievua.courseproject;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

import com.shao.MDB.MDB;

public class DataBase {
    private JSONObject sitesJsonObject;
    private JSONObject showsJsonObject;
    private Sites sites;
    private Shows shows;
    private MDB mdb;

    public DataBase() {
        mdb = new MDB();
        sitesJsonObject = parseJSON(mdb.getSitesString());
        showsJsonObject = parseJSON(mdb.getShowsString());
        sites = parseJsonSite(sitesJsonObject);
        shows = parseJsonShows(showsJsonObject);
    }

    private Sites parseJsonSite(JSONObject jsonObject) {
        System.out.println("Parsing JSON Sites");
        Sites sites = new Sites();
        long status = (long) jsonObject.get("status");
        if (status != 200) return null;
        JSONArray jsonArray = (JSONArray) jsonObject.get("message");
        for (Object object : jsonArray) {
            JSONObject jObject = (JSONObject) object;
            Site site = new Site((long) jObject.get("siteId"), (String) jObject.get("name"), (String) jObject.get("widgetUrl"));
            sites.addSite(site);
        }
        return sites;
    }

    private Shows parseJsonShows(JSONObject jsonObject) {
        System.out.println("Parsing JSON Shows");
        Shows shows = new Shows();
        long status = (long) jsonObject.get("status");
        if (status != 200) return null;
        JSONArray jsonArray = (JSONArray) jsonObject.get("message");
        for (Object object : jsonArray) {
            JSONObject jObject = (JSONObject) object;
            Show show = new Show((long) jObject.get("siteId"), (long) jObject.get("showId"), (String) jObject.get("name"), (long) jObject.get("duration"), (String) jObject.get("orgName"), (String) jObject.get("poster"), (String) jObject.get("description"), (String) jObject.get("widgetUrl"), parseJsonEvents((JSONArray) jsonObject.get("events")));
            shows.addShow(show);
        }
        return shows;
    }

    private Events parseJsonEvents(JSONArray jsonArray) {
        //System.out.println("Parsing JSON Events");
        if (jsonArray == null) return null;
        Events events = new Events();
        for (Object object : jsonArray) {
            JSONObject jObject = (JSONObject) object;
            Event event = new Event((long) jObject.get("siteId"), (long) jObject.get("showId"), (long) jObject.get("hallId"), (long) jObject.get("eventId"), (String) jObject.get("displaySiteName"), (String) jObject.get("displaySiteAddr"), (long) jObject.get("origin"), (String) jObject.get("widgetUrl"));
            events.addEvent(event);
        }
        return events;
    }

    private JSONObject parseJSON(StringBuilder jsonString) {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) JSONValue.parse(jsonString.toString());
        return jsonObject;
    }

    public Sites getSites() {
        return sites;
    }

    public Shows getShows() {
        return shows;
    }
}
