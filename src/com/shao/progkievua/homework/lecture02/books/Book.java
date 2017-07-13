package com.shao.progkievua.homework.lecture02.books;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

final class Book {
    private static List<String> binds = Arrays.asList(
            "Saddle-stitching", "Perfect Binding", "Section Sewn",
            "Wire Binding", "Spiral Binding", "Cased-in Wiro Binding",
            "Pamphlet Binding", "Coptic Binding", "Japanese Binding",
            "Screw-post Binding");
    private static int lastId;
    private final int id;
    private final String name;
    private final ArrayList<String> authors;
    private final String pubHouse;
    private final int pubYear;
    private final int pagesQuantity;
    private final double price;
    private final int bindingType;

    Book() {
        Random random = new Random();
        this.id = lastId++;
        this.name = "BookName" + random.nextInt(1000);
        authors = new ArrayList<>();
        for (int i = 0; i < random.nextInt(3) + 1; i++) {
            authors.add("Author" + random.nextInt(3));
        }
        this.pubHouse = "PubHouse" + random.nextInt(3);
        this.pubYear = 1900 + random.nextInt(100);
        this.pagesQuantity = random.nextInt(1000);
        this.price = (int) ((random.nextDouble() * 400 + 100) * 100) / 100;
        this.bindingType = random.nextInt(binds.size());
    }


    @Override
    public String toString() {
        StringBuilder book = new StringBuilder();
        book
                .append("Id: ").append(id).append(". ")
                .append("Name: ").append(name).append(". ")
                .append("Authors: ").append(getAuthors()).append(". ")
                .append("PubHouse: ").append(pubHouse).append(". ")
                .append("Year: ").append(pubYear).append(". ")
                .append("Pages: ").append(pagesQuantity).append(". ")
                .append("Bind: ").append(getBindingType()).append(". ")
                .append("Price: ").append(getPrice()).append(". ");
        return book.toString();
    }

    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    String getAuthors() {
        StringBuilder authors = new StringBuilder();
        for (int i = 0; i < this.authors.size(); i++) {
            authors.append(this.authors.get(i));
            if (i < this.authors.size() - 1) authors.append(", ");
        }
        return authors.toString();
    }

    String getPubHouse() {
        return pubHouse;
    }

    int getPubYear() {
        return pubYear;
    }

    int getPagesQuantity() {
        return pagesQuantity;
    }

    String getPrice() {
        return price + " UAH";
    }

    String getBindingType() {
        return binds.get(bindingType);
    }

    boolean checkAuthor(String author) {
        for (String s : authors) {
            if (s.equals(author)) return true;
        }
        return false;
    }

}
