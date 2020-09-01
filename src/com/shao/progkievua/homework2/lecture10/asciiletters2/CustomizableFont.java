package com.shao.progkievua.homework2.lecture10.asciiletters2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CustomizableFont implements DrawableFont, Serializable {
    private static final long serialVersionUID = 5716377791490901534L;
    private Map<Character, String[]> font;

    public CustomizableFont() {
        font = new HashMap<>();
    }

    public void loadFontFromFile(String filePath) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
        font = (Map<Character, String[]>) ois.readObject();
    }

    public String drawToString(String line) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            for (char c : line.toCharArray()) {
                result.append(font.get(c)[i]);
            }
            result.append(System.lineSeparator());
        }
        return result.toString();
    }

    public Map<Character, String[]> getFont() {
        return font;
    }

    public void setFont(Map<Character, String[]> font) {
        this.font = font;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomizableFont)) return false;
        CustomizableFont that = (CustomizableFont) o;
        return Objects.equals(font, that.font);
    }

    @Override
    public int hashCode() {
        return Objects.hash(font);
    }

    @Override
    public String toString() {
        return "CustomizableFont{" +
                "font=" + font +
                '}';
    }
}
