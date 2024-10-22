package com.electron.electron.Data;

import com.electron.electron.entity.Book;

import java.util.List;

public class BookData {
    private Book book;
    private List<Book> books;

    public BookData() {
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }


}
