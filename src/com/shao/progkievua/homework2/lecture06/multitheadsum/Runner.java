package com.shao.progkievua.homework2.lecture06.multitheadsum;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Runner {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int arraySize = 200_000_000;
        System.out.println("1. Generating array of " + arraySize + " elements. Please, wait!");
        List<Integer> integerList = generateList(arraySize);
        System.out.print("2. Calculating sum in one thread: \t");
        long oneThreadTimeStampBegin = System.currentTimeMillis();
        System.out.print(listSum(integerList));
        long oneThreadTimeStampEnd = System.currentTimeMillis();
        System.out.println("\t(" + (oneThreadTimeStampEnd - oneThreadTimeStampBegin) + " millis)");
        System.out.print("3. Calculating sum in multi threads: \t");
        long multiThreadTimeStampBegin = System.currentTimeMillis();
        System.out.print(multiThreadListSum(integerList));
        long multiThreadTimeStampEnd = System.currentTimeMillis();
        System.out.println("\t(" + (multiThreadTimeStampEnd - multiThreadTimeStampBegin) + " millis)");
    }

    private static List<Integer> generateList(int size) {
        Random random = new Random();
        return IntStream.range(0, size).mapToObj(i -> random.nextInt(10)).collect(Collectors.toList());
    }

    private static int listSum(List<Integer> integerList) {
        return integerList.stream().mapToInt(integer -> integer).sum();
    }

    private static int multiThreadListSum(List<Integer> integerList) throws ExecutionException, InterruptedException {
        int sum = 0;
        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Future<Integer>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            futures.add(executor.submit(new RangeListSum(
                    integerList,
                    i * integerList.size() / 10,
                    i != 9 ? (i + 1) * integerList.size() / 10 - 1 : integerList.size() - 1)));
        }
        for (Future<Integer> future : futures) {
            sum += future.get();
        }
        executor.shutdown();
        return sum;
    }
}
