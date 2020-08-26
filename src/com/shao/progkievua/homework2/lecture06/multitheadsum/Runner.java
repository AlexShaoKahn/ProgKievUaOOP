package com.shao.progkievua.homework2.lecture06.multitheadsum;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Runner {
    public static void main(String[] args) {
        int arraySize = 200_000_000;
        System.out.println("1. Generating array of " + arraySize + " elements. Please, wait!");
        int[] intArray = generateList(arraySize);
        System.out.print("2. Calculating sum in one thread: \t");
        System.out.print(listSum(intArray));
        System.out.println(" " + listSumAverage(intArray, 100));
        System.out.print("3. Calculating sum in multi threads: \t");
        try {
            System.out.print(multiThreadListSum(intArray, 4));
            System.out.println(" " + multiThreadListSumAverage(intArray, 5, 100));
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static int[] generateList(int size) {
        Random random = new Random();
        int[] intArray = new int[size];
        for (int i = 0; i < size; i++) {
            intArray[i] = random.nextInt(10);
        }
        return intArray;
    }

    private static long listSum(int[] intArray) {
        long sum = 0;
        for (int i : intArray) {
            sum += i;
        }
        return sum;
    }

    private static long multiThreadListSum(int[] intArray, int threadsNum) throws ExecutionException, InterruptedException {
        long sum = 0;
        ExecutorService executor = Executors.newFixedThreadPool(threadsNum);
        List<Future<Integer>> futures = new ArrayList<>();
        int partSize = intArray.length / threadsNum;
        int partBegin;
        int partEnd;
        for (int i = 0; i < threadsNum; i++) {
            partBegin = i * partSize;
            partEnd = (i + 1) * partSize - 1;
            futures.add(executor.submit(new RangeListSum(
                    intArray,
                    partBegin,
                    intArray.length - partEnd < partSize ? intArray.length - 1 : partEnd)));
        }
        for (Future<Integer> future : futures) {
            sum += future.get();
        }
        executor.shutdown();
        return sum;
    }

    private static String listSumAverage(int[] intArray, int simulationsNumber) {
        long oneThreadTimeStampBegin;
        long oneThreadTimeStampEnd;
        long mils = 0;
        for (int i = 0; i < simulationsNumber; i++) {
            oneThreadTimeStampBegin = System.currentTimeMillis();
            listSum(intArray);
            oneThreadTimeStampEnd = System.currentTimeMillis();
            mils += oneThreadTimeStampEnd - oneThreadTimeStampBegin;
        }

        return "(average millis for " + simulationsNumber + " times is " + (mils / simulationsNumber + ")");
    }

    private static String multiThreadListSumAverage(int[] intArray, int threadNum, int simulationsNumber) throws ExecutionException, InterruptedException {
        long oneThreadTimeStampBegin;
        long oneThreadTimeStampEnd;
        long mils = 0;
        for (int i = 0; i < simulationsNumber; i++) {
            oneThreadTimeStampBegin = System.currentTimeMillis();
            multiThreadListSum(intArray, threadNum);
            oneThreadTimeStampEnd = System.currentTimeMillis();
            mils += oneThreadTimeStampEnd - oneThreadTimeStampBegin;
        }

        return "(average millis for " + simulationsNumber + " times is " + (mils / simulationsNumber + ")");
    }

}
