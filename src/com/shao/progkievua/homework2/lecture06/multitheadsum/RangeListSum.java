package com.shao.progkievua.homework2.lecture06.multitheadsum;

import java.io.Serializable;
import java.util.concurrent.Callable;

public class RangeListSum implements Callable<Integer>, Serializable {
    private int[] intArray;
    private int fromIndex;
    private int toIndex;

    public RangeListSum(int[] intArray, int fromIndex, int toIndex) {
        this.fromIndex = fromIndex;
        this.toIndex = toIndex;
        this.intArray = intArray;
    }

    private int getRangeSum() {
        int sum = 0;
        for (int i = fromIndex; i <= toIndex; i++) {
            sum += intArray[i];
        }
        return sum;
    }

    @Override
    public Integer call() {
        return getRangeSum();
    }
}
