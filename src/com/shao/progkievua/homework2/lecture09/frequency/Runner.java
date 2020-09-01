package com.shao.progkievua.homework2.lecture09.frequency;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args) {
        Map<Character, Integer> map = new LinkedHashMap<>();

        try {
            String str = Files.readString(Paths.get(".\\src\\com\\shao\\progkievua\\homework2\\lecture09\\frequency\\text.txt"));
            for (char strChar : str.toCharArray()) {
                if ((strChar >= 'A' && strChar <= 'Z') || (strChar >= 'a' && strChar <= 'z')) {
                    map.putIfAbsent(strChar, 1);
                    map.replace(strChar, map.get(strChar) + 1);
                }
            }

            Map<Character, Integer> sortedMap = map
                    .entrySet()
                    .stream()
                    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                    .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));

            sortedMap
                    .entrySet()
                    .stream()
                    .map(charIntegerEntry -> charIntegerEntry.getKey() + ": "
                            + String.format("% .1f", 100. * charIntegerEntry.getValue() / str.length()) + "%")
                    .forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
