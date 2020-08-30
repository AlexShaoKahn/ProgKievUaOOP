package com.shao.progkievua.homework2.lecture10.dupescounter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DupesCounter<T extends Comparable> {
    private T[] array;

    public DupesCounter() {
    }

    public DupesCounter(T[] array) {
        this.array = array;
    }

    public Map<T, Integer> countDupes() {
        Map<T, Integer> map = new HashMap<>();
        Arrays.stream(array).forEach(t -> {
            if (!map.containsKey(t)) map.putIfAbsent(t, 1);
            else map.replace(t, map.get(t) + 1);
        });
        return map;
    }

    public String dupesToString() {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<T, Integer> tIntegerEntry : countDupes().entrySet()) {
            result.append(tIntegerEntry.getKey()).append(" => ").append(tIntegerEntry.getValue()).append(System.lineSeparator());
        }
        return result.toString();
    }
}
