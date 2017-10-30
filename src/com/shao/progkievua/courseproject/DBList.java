package com.shao.progkievua.courseproject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DBList<T> implements Iterable<T> {
    private List<T> elements = new ArrayList<>();

    public void add(T e) {
        elements.add(e);
    }

    public StringBuilder list() {
        StringBuilder result = new StringBuilder();
        for (T element : elements) {
            result.append(element).append("\n");
        }
        return result;
    }


    @Override
    public Iterator<T> iterator() {
        return elements.iterator();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (T element : elements) {
            result.append(element).append("\n");
        }
        return result.toString();
    }
}
