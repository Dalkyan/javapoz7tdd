package com.sda.service.bookstore;

import java.util.ArrayList;
import java.util.List;

public class Bookstore {

    private final List<Book> books;

    public Bookstore(List<Book> books) {
        this.books = new ArrayList<>();
    }

    public Bookstore() {
        this.books = new ArrayList<>();
    }

    public void add(Book book) {
        this.books.add(book);
    }

    public void updateTitle(Book book, String title) {
        books.get(0).setTitle(title);
    }

    public List<Book> getBooks() {
        return books;
    }




}
