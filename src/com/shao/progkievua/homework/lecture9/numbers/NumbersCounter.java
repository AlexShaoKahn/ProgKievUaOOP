package com.shao.progkievua.homework.lecture9.numbers;

import java.util.*;

public class NumbersCounter {
    public static void main(String[] args) {
        List<Integer> list = fillArray();
        Map<Integer, Integer> count = new HashMap<>();

        for (Integer integer : list) {
            count.put(integer, count.containsKey(integer) ? count.get(integer) + 1 : 1);
        }

        System.out.println(list);
        for (Map.Entry<Integer, Integer> countEntry : count.entrySet()) {
            System.out.println("Number " + countEntry.getKey() + ": " + countEntry.getValue() + " times");
        }

    }

    private static List<Integer> fillArray() {
        Random random = new Random();
        List<Integer> array = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            array.add(random.nextInt(5) + 1);
        }
        return array;
    }
}
