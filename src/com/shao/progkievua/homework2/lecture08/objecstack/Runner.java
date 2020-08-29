package com.shao.progkievua.homework2.lecture08.objecstack;

import java.math.BigInteger;
import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        ClassBlackList blackList = new ClassBlackList();
        ObjectStack objectStack = new ObjectStack(blackList);

        objectStack.push(100);
        objectStack.push(200f);
        objectStack.push(300d);
        objectStack.push("Hello");
        objectStack.push(new ArrayList<Integer>());
        objectStack.push(new StringBuilder());
        objectStack.push(false);
        objectStack.push(500);
        objectStack.push(new BigInteger("600"));
        objectStack.push(args);
        objectStack.push("Latest element");

        System.out.println(objectStack);

        System.out.println(objectStack.peek());
        System.out.println(objectStack.pop());
        System.out.println();

        System.out.println(objectStack);

        blackList.addClass(String.class);
        objectStack.push("Latest element");
    }
}
