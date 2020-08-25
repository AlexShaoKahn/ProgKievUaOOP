package com.shao.progkievua.homework2.lecture06.shellmultithread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Runner {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] array = generateArray(50);
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

    private static int[] multiThreadShellSort(int[] array, int threadsNumber) throws ExecutionException, InterruptedException {
        int[] result = new int[array.length];
        int index = 0;
        int threads = threadsNumber > 10 ? 10 : threadsNumber < 1 ? 1 : threadsNumber;
        ExecutorService executor = Executors.newFixedThreadPool(threads);
        List<Future<int[]>> futures = new ArrayList<>();
        for (int i = 0; i < threads; i++) {
            futures.add(executor.submit(new ShellSort(Arrays.copyOfRange(array, i * array.length / threads, i == threads - 1 ? array.length : (i + 1) * array.length / threads))));
        }
        for (Future<int[]> future : futures) {
            for (int i : future.get()) {
                result[index++] = i;
            }
        }
        futures.add(executor.submit(new ShellSort(result)));
        executor.shutdown();
        return futures.get(futures.size() - 1).get();
    }


}
