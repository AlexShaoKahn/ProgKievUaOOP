package com.shao.progkievua.homework.lecture8.listqueue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedStack<E> implements Stack<E> {
    private Node<E> tail = null;
    private Node<E> first = null;
    private int size = 0;

    @Override
    public void push(E elem) {
        size++;
        tail = new Node<>(elem, tail);
        if (size == 1) first = tail;
    }

    @Override
    public E pop() {
        size--;
        E prev = tail.item;
        tail = tail.prev;
        return prev;
    }

    @Override
    public E peek() {
        return tail.item;
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
        return new LinkedStackIterator();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder()
                .append("Linked Stack Size: ")
                .append(size)
                .append("\n")
                .append("[");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            result.append(node.item).append(", ");
            node = node.next;
        }
        result.append("]");
        return result.deleteCharAt(result.length() - 2).deleteCharAt(result.length() - 2).toString();
    }

    private static class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next = null;

        Node(E item, Node<E> prev) {
            this.item = item;
            this.prev = prev;
            if (this.prev != null) this.prev.next = this;
        }
    }

    private class LinkedStackIterator implements Iterator<E> {

        private int currentIndex = 0;
        private Node<E> node = first;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            currentIndex++;
            E item = node.item;
            node = node.next;
            return item;
        }
    }
}
