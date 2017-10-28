package com.shao.progkievua.homework.lecture8.listqueue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class LinkedListQueue<E> implements Queue<E> {
    private LinkedList<E> list = new LinkedList<>();

    @Override
    public void offer(E e) {
        list.add(e);
    }

    @Override
    public E remove() {
        if (isEmpty()) throw new NoSuchElementException("There're no elements!");
        E item = list.getFirst();
        list.removeFirst();
        return item;
    }

    @Override
    public E poll() {
        if (isEmpty()) return null;
        E item = list.getFirst();
        list.removeFirst();
        return item;
    }

    @Override
    public E element() {
        if (isEmpty()) throw new NoSuchElementException("There're no elements!");
        return list.getFirst();
    }

    @Override
    public E peek() {
        return isEmpty() ? null : list.getFirst();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return size() <= 0;
    }

    @Override
    public boolean contains(E elem) {
        return list.contains(elem);
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Linked List Queue Size: ")
                .append(list.size())
                .append("\n[");
        for (int i = list.size() - 1; i >= 0; i--) {
            result.append(list.get(i)).append(", ");
        }
        result.append("]");
        return result.deleteCharAt(result.length() - 2).deleteCharAt(result.length() - 2).toString();
    }
}
