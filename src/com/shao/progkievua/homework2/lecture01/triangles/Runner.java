package com.shao.progkievua.homework2.lecture01.triangles;

import java.util.Arrays;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<Triangle> triangles = Arrays.asList(new Triangle(), new Triangle(), new Triangle());
        for (Triangle triangle : triangles) {
            System.out.println(triangle);
        }
    }
}
