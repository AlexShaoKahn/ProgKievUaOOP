package com.shao.progkievua.homework2.lecture09.listdeladd;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Runner {
    public static void main(String[] args) {
        System.out.println(listCreateDelAdd());
    }

    private static List<Integer> listCreateDelAdd() {
        List<Integer> integerList = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            integerList.add(random.nextInt(100));
        }
        integerList.remove(1);
        integerList.remove(1);
        integerList.remove(integerList.size() - 1);
        return integerList;
    }
}
