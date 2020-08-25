package com.shao.progkievua.homework2.lecture06.factorialthreads;

import java.io.Serializable;
import java.math.BigInteger;

public class FactorialCalc implements Runnable, Serializable {
    private int num;

    public FactorialCalc(int num) {
        this.num = num;
    }

    private BigInteger getFactorial(int num) {
        return num == 1 ? new BigInteger("1") : getFactorial(num - 1).multiply(new BigInteger(Integer.toString(num)));
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "\t" + getFactorial(num));
    }
}
