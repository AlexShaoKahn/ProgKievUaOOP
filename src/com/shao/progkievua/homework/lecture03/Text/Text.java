package com.shao.progkievua.homework.lecture03.Text;

import java.util.ArrayList;
import java.util.List;

public class Text {
    private List<Sentence> text;
    private String title;

    public Text(String title) {
        text = new ArrayList<>();
        this.title = title;
    }

    public Text addText(String text) {
        String[] buffer = (text + "\n").split(" ");
        this.text.add(new Sentence(buffer));
        return this;
    }

    public Text newLine() {
        text.add(new Sentence(new String[]{"\n"}));
        return this;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder().append("Title: ").append(title)
                .append("\n---------------------------------------------------------\n\n");
        for (Sentence sentence : text) {
            sb.append(sentence.toString());
        }
        return sb.toString();
    }
}
