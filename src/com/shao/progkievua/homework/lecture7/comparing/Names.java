package com.shao.progkievua.homework.lecture7.comparing;

import jdk.nashorn.internal.ir.WhileNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Names {
    private List<String> names = new ArrayList<>();

    public Names(List<String> names) {
        this.names = names;
    }

    public Names(String... names) {
        for (String name : names) {
            this.names.add(name);
        }
    }

    public List<String> alphabetSort() {
        List<String> names = new ArrayList<>(this.names);
        Collections.sort(names);
        return names;
    }

    public List<String> alphabetReverseSort() {
        List<String> names = new ArrayList<>(this.names);
        Collections.reverse(names);
        return names;
    }

    public String getMinAlphabetName() {
        List<String> names = new ArrayList<>(this.names);
        return getMin(names);
    }

    private List<String> lengthSort() {
        List<String> names = new ArrayList<>(this.names);
        Collections.sort(names, new LengthComparator());
        return names;
    }

    public List<String> lengthRevAlphaSort() {
        List<String> names = lengthSort();
        for (int i = 0; i < names.size() - 1; i++) {
            int j = i + 1;
            while (j < names.size() && names.get(i).length() == names.get(j).length()) {
                j++;
            }
            if (j - i - 1 > 0) {
                List<String> list = new ArrayList<>();
                for (int l = 0; l < j - i; l++) {
                    list.add(names.get(i + l));
                }
                Collections.sort(list);
                Collections.reverse(list);
                for (int l = 0; l < list.size(); l++) {
                    names.set(i + l, list.get(l));
                }
            }
        }
        return names;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (String name : names) {
            result.append(name).append(", ");
        }
        return result.substring(0, result.length() - 2) + "]";
    }

    private <T extends Comparable<T>> T getMin(List<T> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("empty list");
        }

        T min = list.get(0);
        for (T elem : list) {
            if (min.compareTo(elem) > 0) { // !
                min = elem;
            }
        }
        return min;
    }

}

class LengthComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        return Integer.compare(s1.length(), s2.length());
    }
}