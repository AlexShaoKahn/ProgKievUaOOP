package com.shao.progkievua.courseproject;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;

public class DataBase {
    private final String SITES_REQUEST = "https://partner.mticket.com.ua/api/sites?login=shao&signature=d793851f6caf633a6350d8a541138c30";
    private final String SHOWS_REQUEST = "https://partner.mticket.com.ua/api/shows?login=shao&signature=60c99cd7f2d6abbb7d31b730feb9531e";
    private final String USER_AGENT = "Mozilla/5.0";
    private final String DB_SITES_FILE = "db_sites.json";
    private final String DB_SHOWS_FILE = "db_shows.json";
    private JSONObject sitesJsonObject;
    private JSONObject showsJsonObject;
    private StringBuilder sitesString;
    private StringBuilder showsString;
    private DBList<Site> sites;
    private DBList<Show> shows;

    private void SaveDBFile(String dbFileName, StringBuilder dbString) {
        File dbFile = new File(dbFileName);
        if (!dbFile.exists()) try {
            dbFile.createNewFile();
            PrintWriter out = new PrintWriter(dbFile.getAbsoluteFile());
            try {
                out.print(dbString);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void SaveDataBase() {
        SaveDBFile(DB_SITES_FILE, sitesString);
        SaveDBFile(DB_SHOWS_FILE, showsString);
    }

    private JSONObject LoadDbFile(String dbFileName, StringBuilder dbString) throws FileNotFoundException {
        File dbFile = new File(dbFileName);
        dbString = new StringBuilder();
        existsFile(dbFileName);
        try {
            BufferedReader in = new BufferedReader(new FileReader(dbFile.getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    dbString.append(s);
                    dbString.append("\n");
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return parseJSON(dbString);
    }

    public void LoadDataBase() throws FileNotFoundException {
        sites = parseJsonSite(LoadDbFile(DB_SITES_FILE, sitesString));
        shows = parseJsonShows(LoadDbFile(DB_SHOWS_FILE, showsString));
    }

    private void existsFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException(file.getName());
        }
    }

    public void UpdateDataBase() {
        try {
            sitesString = getData(SITES_REQUEST);
        } catch (IOException e) {
            sitesString = new StringBuilder().append("{\"Error\":\"IOExeption:\" ").append(e).append("}");
        }
        try {
            showsString = getData(SHOWS_REQUEST);
        } catch (IOException e) {
            showsString = new StringBuilder().append("{\"Error\":\"IOExeption:\" ").append(e).append("}");
        }
        sitesJsonObject = parseJSON(sitesString);
        showsJsonObject = parseJSON(showsString);
        sites = parseJsonSite(sitesJsonObject);
        shows = parseJsonShows(showsJsonObject);
    }

    private StringBuilder getData(String request) throws IOException {
        URL url = new URL(request);
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = connection.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuffer response = new StringBuffer();

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        in.close();
        return new StringBuilder(response);
    }

    private DBList<Site> parseJsonSite(JSONObject jsonObject) {
        DBList<Site> sites = new DBList<>();
        long status = (long) jsonObject.get("status");
        if (status != 200) return null;
        JSONArray jsonArray = (JSONArray) jsonObject.get("message");
        for (Object object : jsonArray) {
            JSONObject jObject = (JSONObject) object;
            Site site = new Site(
                    (long) jObject.get("siteId"),
                    (String) jObject.get("name"),
                    (String) jObject.get("widgetUrl")
            );
            sites.add(site);
        }
        return sites;
    }

    private DBList<Show> parseJsonShows(JSONObject jsonObject) {
        DBList<Show> shows = new DBList<>();
        long status = (long) jsonObject.get("status");
        if (status != 200) return null;
        JSONArray jsonArray = (JSONArray) jsonObject.get("message");
        for (Object object : jsonArray) {
            JSONObject jObject = (JSONObject) object;
            //System.out.println(((JSONObject) object).get("events"));
            //System.exit(1);
            Show show = new Show(
                    (long) jObject.get("siteId"),
                    (long) jObject.get("showId"),
                    (String) jObject.get("name"),
                    (long) jObject.get("duration"),
                    (String) jObject.get("orgName"),
                    (String) jObject.get("poster"),
                    (String) jObject.get("description"),
                    (String) jObject.get("widgetUrl"),
                    parseJsonEvents((JSONArray) jObject.get("events"))
            );
            shows.add(show);
        }
        return shows;
    }

    private DBList<Event> parseJsonEvents(JSONArray jsonArray) {
        if (jsonArray == null) return null;
        DBList<Event> events = new DBList<>();
        for (Object object : jsonArray) {
            JSONObject jObject = (JSONObject) object;
            Event event = new Event(
                    (long) jObject.get("siteId"),
                    (long) jObject.get("showId"),
                    (long) jObject.get("hallId"),
                    (long) jObject.get("eventId"),
                    (String) jObject.get("displaySiteName"),
                    (String) jObject.get("displaySiteAddr"),
                    (String) jObject.get("origin"),
                    (String) jObject.get("widgetUrl")
            );
            events.add(event);
        }
        return events;
    }

    private JSONObject parseJSON(StringBuilder jsonString) {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) JSONValue.parse(jsonString.toString());
        return jsonObject;
    }

    public DBList<Site> getSites() {
        return sites;
    }

    public DBList<Show> getShows() {
        return shows;
    }
}
