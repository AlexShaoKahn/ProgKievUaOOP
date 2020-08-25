package com.shao.progkievua.homework2.lecture06.multitheadsum;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.IntStream;

public class RangeListSum implements Callable<Integer>, Serializable {
    private List<Integer> integerList;
    private int fromIndex;
    private int toIndex;

    public RangeListSum(List<Integer> integerList, int fromIndex, int toIndex) {
        this.fromIndex = fromIndex;
        this.toIndex = toIndex;
        this.integerList = integerList;
    }

    private int getRangeSum() {
        return IntStream.rangeClosed(fromIndex, toIndex).map(i -> integerList.get(i)).sum();
    }

    @Override
    public Integer call() {
        return getRangeSum();
    }
}
