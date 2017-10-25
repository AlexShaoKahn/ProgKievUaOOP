package com.shao.progkievua.homework.lecture7.pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PairRunner {
    public static void main(String[] args) {
        Random random = new Random();
        List<Pair<Integer, String>> pairs = new ArrayList<>();

        for (int i = 0; i < random.nextInt(5) + 5; i++) {
            pairs.add(new Pair<>((random.nextInt(900) + 100), "String" + (random.nextInt(900) + 100)));
        }

        for (Pair<Integer, String> pair : pairs) {
            System.out.println(pair);
        }
    }
}
