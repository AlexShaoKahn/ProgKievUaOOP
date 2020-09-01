package com.shao.progkievua.homework2.lecture11.urllistcheck;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class Runner {
    public static void main(String[] args) {
        checkUrls(readUrlsFromFile(".\\src\\com\\shao\\progkievua\\homework2\\lecture11\\urllistcheck\\urlList.txt"));
    }


    private static Set<String> readUrlsFromFile(String urlListFilePath) {
        Set<String> urlsSet = new HashSet<>();
        try (Stream<String> stream = Files.lines(Paths.get(urlListFilePath))) {
            stream.forEach(urlsSet::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return urlsSet;
    }

    private static void checkUrls(Set<String> urlsSet) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (String ulrLink : urlsSet) {
            executorService.submit(() -> System.out.println(checkUrl(ulrLink)));
        }
        executorService.shutdown();
    }

    private static String checkUrl(String urlString) {
        try {
            URL url = new URL(urlString);
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                if (httpURLConnection.getResponseCode() >= 200 && httpURLConnection.getResponseCode() < 300)
                    return urlString + "- connected";
            } catch (IOException e) {
                return urlString + " - error connecting";
                //e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            return urlString + " - not registered";
            //e.printStackTrace();
        }
        return urlString + " - unknown error";
    }
}
