package com.shao.progkievua.homework.lecture8.listqueue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicQueue<E> implements Queue<E> {
    private E[] elems = (E[]) new Object[8];
    ;
    private int size = 0;

    @Override
    public void offer(E e) {
        if (size == elems.length) {
            E[] newElems = (E[]) new Object[(int) (elems.length * 1.5)];
            System.arraycopy(elems, 0, newElems, 0, elems.length);
            elems = newElems;
        }
        elems[size++] = e;
    }

    @Override
    public E remove() {
        if (size * 4 == elems.length) {
            E[] newElems = (E[]) new Object[(int) (size * 2)];
            System.arraycopy(elems, 0, newElems, 0, elems.length);
            elems = newElems;
        }
        if (isEmpty()) throw new NoSuchElementException("There're no elements!");
        E elem = elems[0];
        size--;
        for (int i = 0; i < size; i++) {
            elems[i] = elems[i + 1];
        }
        return elem;
    }


    @Override
    public E poll() {
        if (size * 4 == elems.length) {
            E[] newElems = (E[]) new Object[(int) (size * 2)];
            System.arraycopy(elems, 0, newElems, 0, elems.length);
            elems = newElems;
        }
        if (isEmpty()) return null;
        E elem = elems[0];
        size--;
        for (int i = 0; i < size; i++) {
            elems[i] = elems[i + 1];
        }
        return elem;
    }

    @Override
    public E element() {
        if (isEmpty()) throw new NoSuchElementException("There're no elements!");
        return elems[0];
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        return elems[0];
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
    public boolean contains(E elem) {
        for (E e : elems) {
            if (e.equals(elem)) return true;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new DynamicArrayQueueIterator();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Dynamic Queue Size: ")
                .append(size)
                .append("\n")
                .append("[");
        for (int i = 0; i < size; i++) {
            result.append(elems[i]).append(", ");
        }
        result.append("]");
        return result.deleteCharAt(result.length() - 2).deleteCharAt(result.length() - 2).toString();
    }

    private class DynamicArrayQueueIterator implements Iterator<E> {

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
