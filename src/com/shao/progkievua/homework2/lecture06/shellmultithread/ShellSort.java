package com.shao.progkievua.homework2.lecture06.shellmultithread;

import java.util.concurrent.Callable;

public class ShellSort implements Callable<int[]> {
    private int[] array;

    public ShellSort(int[] array) {
        this.array = array;
    }

    @Override
    public int[] call() {
        int temp;
        int h = 0;

        while (h <= array.length / 3)
            h = 3 * h + 1;

        for (int k = h; k > 0; k = (k - 1) / 3)
            for (int i = k; i < array.length; i++) {
                temp = array[i];
                int j;
                for (j = i; j >= k; j -= k) {
                    if (temp < array[j - k])
                        array[j] = array[j - k];
                    else
                        break;
                }
                array[j] = temp;
            }
        return array;
    }
}
