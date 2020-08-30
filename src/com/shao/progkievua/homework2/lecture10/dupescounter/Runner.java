package com.shao.progkievua.homework2.lecture10.dupescounter;

import java.util.Random;

public class Runner {
    public static void main(String[] args) {
        DupesCounter<Integer> intsDupesCounter = new DupesCounter<>(intGenerator());
        System.out.println(intsDupesCounter.dupesToString());

        DupesCounter<Character> charsDupesCounter = new DupesCounter<>(charGenerator());
        System.out.println(charsDupesCounter.dupesToString());

        DupesCounter<Double> doubleDupesCounter = new DupesCounter<>(doubleGenerator());
        System.out.println(doubleDupesCounter.dupesToString());
    }


    private static Integer[] intGenerator() {
        Random random = new Random();
        Integer[] ints = new Integer[random.nextInt(1000)];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = random.nextInt(10);
        }
        return ints;
    }

    private static Character[] charGenerator() {
        Random random = new Random();
        Character[] chars = new Character[random.nextInt(1000)];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (random.nextInt(10) + 'A');
        }
        return chars;
    }

    private static Double[] doubleGenerator() {
        Random random = new Random();
        Double[] doubles = new Double[random.nextInt(1000)];
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = Math.round(random.nextDouble() * 100) / 10.;
        }
        return doubles;
    }
}
