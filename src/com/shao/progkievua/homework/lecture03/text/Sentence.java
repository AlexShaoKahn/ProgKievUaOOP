package com.shao.progkievua.homework.lecture03.text;

import java.util.ArrayList;
import java.util.List;

public class Sentence {
    private List<Word> sentence;

    public Sentence() {
        sentence = new ArrayList<>();
    }

    public Sentence(String[] text) {
        this();
        for (String word : text) {
            sentence.add(new Word(word));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sentence.size(); i++) {
            sb.append(sentence.get(i).getWord());
            if (i < sentence.size() - 1) sb.append(" ");
        }
        sb.replace(0, 1, sb.substring(0, 1).toUpperCase());
        //sb.append(".");
        return sb.toString();
    }
}
