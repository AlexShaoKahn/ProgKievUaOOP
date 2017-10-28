package com.shao.progkievua.homework.lecture8.listqueue;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListStack<E> implements Stack<E> {
    private LinkedList<E> list = new LinkedList<>();

    @Override
    public void push(E elem) {
        list.push(elem);
    }

    @Override
    public E pop() {
        return list.pop();
    }

    @Override
    public E peek() {
        return list.peek();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Linked List Stack Size: ")
                .append(list.size())
                .append("\n[");
        for (int i = list.size() - 1; i >= 0; i--) {
            result.append(list.get(i)).append(", ");
        }
        result.append("]");
        return result.deleteCharAt(result.length() - 2).deleteCharAt(result.length() - 2).toString();
    }
}
