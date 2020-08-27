package com.shao.progkievua.homework2.lecture06.shellmultithread;

public class ShellSort implements Runnable {
    private int[] array;
    Thread thr;
    private int begin;
    private int end;
    private int index;
    private boolean stop = false;

    public ShellSort(int[] array, int begin, int end) {
        this.array = array;
        this.begin = begin;
        this.end = end;
        thr = new Thread(this);
        thr.start();
        index = begin;
    }

    public Thread getThr() {
        return thr;
    }

    public int getElement() {
        return array[index];
    }

    public boolean isStop() {
        return stop;
    }

    public int pushElement() {
        int temp = array[index];
        check();
        return temp;
    }

    private void check() {
        index++;
        if (index > end) stop = true;
    }

    @Override
    //https://ru.wikipedia.org/wiki/%D0%A1%D0%BE%D1%80%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%BA%D0%B0_%D0%A8%D0%B5%D0%BB%D0%BB%D0%B0
    public void run() {
        int n = end - begin + 1;
        for (int step = n / 2; step > 0; step /= 2) {
            for (int i = step; i < n; i++) {
                for (int j = i - step; j >= 0 && array[j + begin] > array[j + step + begin]; j -= step) {
                    int x = array[j + begin];
                    array[j + begin] = array[j + step + begin];
                    array[j + step + begin] = x;
                }
            }
        }
    }
}
