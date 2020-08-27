package com.shao.progkievua.homework2.lecture06.shellmultithread;

import java.util.Arrays;
import java.util.Random;

public class Runner {
    public static void main(String[] args) {
        int[] array = generateArray(20);
        System.out.println("Unsorted array:");
        System.out.println(Arrays.toString(array));
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(multiThreadShellSort(array, 5)));
    }

    private static int[] generateArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000);
        }
        return array;
    }

    private static int[] multiThreadShellSort(int[] array, int threadsNumber) {
        ShellSort[] shellSorts = new ShellSort[threadsNumber];
        int step = array.length / threadsNumber;
        int begin;
        int end;
        for (int i = 0; i < threadsNumber; i++) {
            begin = i * step;
            end = (i + 1) * step - 1;
            if (i == threadsNumber - 1) end = array.length - 1;
            shellSorts[i] = new ShellSort(array, begin, end);
        }
        for (ShellSort shellSort : shellSorts) {
            try {
                shellSort.getThr().join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int[] result = new int[array.length];
        for (int i = 0; i < result.length; i++) {
            int min = Integer.MAX_VALUE;
            int k = -1;
            for (int j = 0; j < shellSorts.length; j++) {
                if (!shellSorts[j].isStop() && min > shellSorts[j].getElement()) {
                    min = shellSorts[j].getElement();
                    k = j;
                }
            }
            if (k != -1) result[i] = shellSorts[k].pushElement();
        }

        return result;
    }

}
