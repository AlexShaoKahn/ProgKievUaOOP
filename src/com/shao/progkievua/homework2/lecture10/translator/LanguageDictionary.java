package com.shao.progkievua.homework2.lecture10.translator;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LanguageDictionary implements WordsTranslator, Serializable {

    private static final long serialVersionUID = 7007288558347699042L;
    private Map<String, String> dictionary;
    private Map<String, String> swappedDictionary;

    public LanguageDictionary() {
        dictionary = new HashMap<>();
        swappedDictionary = new HashMap<>();
    }

    public void addWord() {
        System.out.println("Input word and it's translation divided by SPACE: ");
        addWord(System.console().readLine());
    }

    public void addWord(String line) {
        String[] words = line.split(" ");
        dictionary.putIfAbsent(words[0].toLowerCase(), words[1].toLowerCase());
        swappedDictionary.putIfAbsent(words[1].toLowerCase(), words[0].toLowerCase());
    }

    public void saveToDisk(String fileName) {
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(dictionary);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadDictionaryFromFile(String fileName) {
        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            dictionary = (Map<String, String>) ois.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        swappedDictionary = getSwappedDictionary();
    }

    private Map<String, String> getSwappedDictionary() {
        Map<String, String> swappedDictionary = new HashMap<>();
        for (Map.Entry<String, String> stringStringEntry : dictionary.entrySet()) {
            swappedDictionary.putIfAbsent(stringStringEntry.getValue(), stringStringEntry.getKey());
        }
        return swappedDictionary;
    }

    public void setSwappedDictionary(Map<String, String> swappedDictionary) {
        this.swappedDictionary = swappedDictionary;
    }

    public Map<String, String> getDictionary() {
        return dictionary;
    }

    public void setDictionary(Map<String, String> dictionary) {
        this.dictionary = dictionary;
    }

    @Override
    public String translate(String fromWord) {
        return dictionary.get(fromWord.toLowerCase());
    }

    @Override
    public String translateBack(String fromWord) {
        return swappedDictionary.get(fromWord.toUpperCase());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LanguageDictionary)) return false;
        LanguageDictionary that = (LanguageDictionary) o;
        return Objects.equals(dictionary, that.dictionary) &&
                Objects.equals(swappedDictionary, that.swappedDictionary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dictionary, swappedDictionary);
    }

    @Override
    public String toString() {
        return "LanguageDictionary " + dictionary;
    }
}
