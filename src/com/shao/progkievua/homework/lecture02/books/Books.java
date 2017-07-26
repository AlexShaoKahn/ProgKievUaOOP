package com.shao.progkievua.homework.lecture02.books;

import java.util.ArrayList;
import java.util.Random;

public class Books {
    private ArrayList<Book> books;

    public Books() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addRandomBooks() {
        Random random = new Random();
        for (int i = 0; i < random.nextInt(10) + 5; i++) {
            addBook(new Book());
        }
    }

    public Books selectByAuthor(String author) {
        Books result = new Books();
        for (Book book : books) {
            if (book.checkAuthor(author)) result.addBook(book);
        }
        return result;
    }

    public Books selectByPubHouse(String pubHouse) {
        Books result = new Books();
        for (Book book : books) {
            if (book.getPubHouse().equals(pubHouse)) result.addBook(book);
        }
        return result;
    }

    public Books selectAfterYear(int pubYear) {
        Books result = new Books();
        for (Book book : books) {
            if (book.getPubYear() > pubYear) result.addBook(book);
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Book book : books) {
            sb.append(book.toString()).append("\n");
        }
        return sb.toString();
    }
}
