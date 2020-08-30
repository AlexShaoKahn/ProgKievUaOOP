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
        Map<Byte, Integer> map = new LinkedHashMap<>();

        try {
            String str = Files.readString(Paths.get(".\\src\\com\\shao\\progkievua\\homework2\\lecture09\\frequency\\text.txt"));

            for (byte strByte : str.getBytes()) {
                if (!map.containsKey(strByte)) map.put(strByte, 1);
                else map.replace(strByte, map.get(strByte) + 1);
            }

            Map<Byte, Integer> sortedMap = map
                    .entrySet()
                    .stream()
                    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                    .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));

            for (Map.Entry<Byte, Integer> byteIntegerEntry : sortedMap.entrySet()) {
                System.out.println(
                        (char) byteIntegerEntry.getKey().intValue() + ": "
                                + String.format("% .1f", 100. * byteIntegerEntry.getValue() / str.length()) + "%");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
