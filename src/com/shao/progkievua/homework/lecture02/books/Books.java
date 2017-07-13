package com.shao.progkievua.homework.lecture02.books;

import java.util.ArrayList;
import java.util.Random;

class Books {
    private ArrayList<Book> books;

    Books() {
        books = new ArrayList<>();
    }

    private void addBook(Book book) {
        books.add(book);
    }

    void addRandomBooks() {
        Random random = new Random();
        for (int i = 0; i < random.nextInt(10) + 5; i++) {
            addBook(new Book());
        }
    }

    Books selectByAuthor(String author) {
        Books result = new Books();
        for (Book book : books) {
            if (book.checkAuthor(author)) result.addBook(book);
        }
        return result;
    }

    Books selectByPubHouse(String pubHouse) {
        Books result = new Books();
        for (Book book : books) {
            if (book.getPubHouse().equals(pubHouse)) result.addBook(book);
        }
        return result;
    }

    Books selectAfterYear(int pubYear) {
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
