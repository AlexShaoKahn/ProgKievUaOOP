package com.shao.progkievua.homework2.lecture11.urlparser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
        String fileNameToWritePath = ".\\src\\com\\shao\\progkievua\\homework2\\lecture11\\urlparser\\parsedUrls.txt";
        try {
            parseUrlsToFile("https://prog.kiev.ua", fileNameToWritePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String parseUrlsToFile(String url, String fileName) throws IOException {
        StringBuilder result = new StringBuilder();
        Set<String> urlsSet = new HashSet<>();

        Document document = Jsoup.connect(url).get();
        Element body = document.body();
        String pageTitle = document.title();
        Elements urls = body.getElementsByTag("a");

        result.append(pageTitle).append(System.lineSeparator());
        for (Element eUrl : urls) {
            String link = eUrl.attr("href");
            if (link != null && link.length() > 0 && link.charAt(0) == '/' && link.contains("htm") && !link.contains("http"))
                link = url + link;
            if (link != null && link.length() > 0 && !(link.charAt(0) == '/') && link.contains("htm") && !link.contains("http"))
                link = url + "/" + link;
            if (link.contains("http")) urlsSet.add(link);
        }

        urlsSet.forEach(sUrl -> result.append(sUrl).append(System.lineSeparator()));

        Files.writeString(Paths.get(fileName), result.toString());

        return result.toString();
    }
}
