package com.shao.progkievua.homework.lecture8.listqueue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicStack<E> implements Stack<E> {
    private E[] elems = (E[]) new Object[8];
    private int size = 0;

    @Override
    public void push(E elem) {
        if (size == elems.length) {
            E[] newElems = (E[]) new Object[(int) (elems.length * 1.5)];
            System.arraycopy(elems, 0, newElems, 0, elems.length);
            elems = newElems;
        }
        elems[size++] = elem;
    }

    @Override
    public E pop() {
        if (size * 4 == elems.length) {
            E[] newElems = (E[]) new Object[(int) (size * 2)];
            System.arraycopy(elems, 0, newElems, 0, elems.length);
            elems = newElems;
        }
        if (isEmpty()) throw new NoSuchElementException("There're no elements!");
        return elems[--size];
    }

    @Override
    public E peek() {
        if (isEmpty()) throw new NoSuchElementException("There're no elements!");
        return elems[size - 1];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size <= 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new DynamicArrayStackIterator();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Dynamic Stack Size: ")
                .append(size)
                .append("\n")
                .append("[");
        for (int i = 0; i < size; i++) {
            result.append(elems[i]).append(", ");
        }
        result.append("]");
        return result.deleteCharAt(result.length() - 2).deleteCharAt(result.length() - 2).toString();
    }

    private class DynamicArrayStackIterator implements Iterator<E> {

        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return elems[currentIndex++];
        }
    }
}
