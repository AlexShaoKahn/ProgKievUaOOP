package com.shao.progkievua.homework.lecture02.books;

public class BooksRunner {
    public static void main(String[] args) {
        Books bookShelf = new Books();
        bookShelf.addRandomBooks();
        String author = "Author0";
        String pubHouse = "PubHouse0";
        int year = 1950;

        Books bookShelfByAuthor = bookShelf.selectByAuthor(author);
        Books bookShelfByPubHouse = bookShelf.selectByPubHouse(pubHouse);
        Books bookShelfAfterYear = bookShelf.selectAfterYear(year);

        System.out.println("Origin bookshelf:");
        System.out.println(bookShelf.toString());
        System.out.println("Bookshelf with author " + author + ":");
        System.out.println(bookShelfByAuthor.toString());
        System.out.println("Bookshelf with publishing house " + pubHouse + ":");
        System.out.println(bookShelfByPubHouse.toString());
        System.out.println("Bookshelf with books after " + year + " year:");
        System.out.println(bookShelfAfterYear.toString());
    }
}
