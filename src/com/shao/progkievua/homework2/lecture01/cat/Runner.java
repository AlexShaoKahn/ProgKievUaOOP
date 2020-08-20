package com.shao.progkievua.homework2.lecture01.cat;

import java.util.Arrays;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<Cat> catsList = Arrays.asList(new Cat("Lucky"), new Cat("Garold"), new Cat("Pickles"));

        for (Cat cat : catsList) {
            System.out.print(cat + ": ");
            cat.voice();
        }

        catsList.get(0).starve();
        catsList.get(1).feed();
        catsList.get(2).setColor(Color.YELLOW);

        System.out.println();
        for (Cat cat : catsList) {
            System.out.println(cat);
        }
    }
}
