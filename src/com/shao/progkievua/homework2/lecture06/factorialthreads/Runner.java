package com.shao.progkievua.homework2.lecture06.factorialthreads;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> threadList = IntStream.rangeClosed(1, 100)
                .mapToObj(i -> new Thread(new FactorialCalc(i), "Thread-" + i))
                .collect(Collectors.toList());
        threadList.forEach(Thread::start);
        for (Thread thread : threadList) thread.join();
    }
}
