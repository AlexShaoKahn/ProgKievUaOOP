package com.shao.progkievua.homework.lecture8.listqueue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<E> implements Queue<E> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    @Override
    public void offer(E e) {
        size++;
        if (tail == null && head == null) {
            tail = new Node<>(e, null, null);
            head = tail;
        }
        tail.prev = new Node<>(e, null, tail);
        tail = tail.prev;
    }

    @Override
    public E remove() {
        if (isEmpty()) throw new NoSuchElementException("There're no elements!");
        size--;
        E item = head.item;
        head = head.prev;
        return item;
    }

    @Override
    public E poll() {
        if (isEmpty()) return null;
        size--;
        E item = head.item;
        head = head.prev;
        return item;
    }

    @Override
    public E element() {
        if (isEmpty()) throw new NoSuchElementException("There're no elements!");
        return head.item;
    }

    @Override
    public E peek() {
        return isEmpty() ? null : head.item;
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
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedQueueIterator();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder()
                .append("Linked Queue Size: ")
                .append(size)
                .append("\n")
                .append("[");
        Node<E> node = tail;
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
        Node<E> next;

        Node(E item, Node<E> prev, Node<E> next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    private class LinkedQueueIterator implements Iterator<E> {

        private int currentIndex = 0;
        private Node<E> node = tail;

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
