package com.electron.electron.entity;

import javax.persistence.*;

@Entity
public class BookAuthor {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name ="book_id",referencedColumnName = "id",nullable = false)
    private Book book;
    @ManyToOne
    @JoinColumn(name ="author_id",referencedColumnName = "id",nullable = false)
    private Author author;

    public BookAuthor() {
    }

    public BookAuthor(Long id, Book book, Author author) {
        this.id = id;
        this.book = book;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "BookAuthor{" +
                "id=" + id +
                ", book=" + book +
                ", author=" + author +
                '}';
    }
}
