package com.shao.progkievua.homework.lecture7.comparing;

public class NamesRunner {
    public static void main(String[] args) {
        Names names = new Names(
                "Schwarzenegger Arnold",
                "Diesel Vin",
                "Arnold Schwarzenegger",
                "Sylvester Stallone",
                "Jan Clod Vandam",
                "Jackie Chan",
                "Bruce Willis",
                "Vin Diesel"
        );
        System.out.println("Original array:");
        System.out.println(names);
        System.out.println("\nAlphabet sort:");
        System.out.println(names.alphabetSort());
        System.out.println("\nReverse alphabet sort:");
        System.out.println(names.alphabetReverseSort());
        System.out.print("\nMinimal alphabet name: ");
        System.out.println(names.getMinAlphabetName());
        System.out.println("\nName length and equal length reverse alphabet sort:");
        System.out.println(names.lengthRevAlphaSort());
    }
}
