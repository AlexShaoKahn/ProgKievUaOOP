package com.shao.progkievua.homework.lecture01.months;

import java.time.Month;
import java.util.Scanner;

public class Months {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int month;

        System.out.print("Enter month number: ");
        while (!isInRange(month = scanner.nextInt())) {
            System.out.print("Wrong month number!\nEnter month number: ");
        }
        System.out.println("Month number " + month + " is " + getMonth(month));

        scanner.close();
    }

    private static String getMonth(int month) {
        return Month.of(month).name();
    }

    private static boolean isInRange(int month) {
        if (month >= 1 && month <= 12) return true;
        else return false;
    }
}
