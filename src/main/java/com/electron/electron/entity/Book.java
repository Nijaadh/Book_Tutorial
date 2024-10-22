package com.electron.electron.entity;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(name="description")
    private String desc;

    private Integer yearOfPublication;
    private String bookType;

    public Book() {
    }

//    public Book(String name, String desc, Integer yearOfPublication, String bookType) {
//        this.name = name;
//        this.desc = desc;
//        this.yearOfPublication = yearOfPublication;
//        this.bookType = bookType;
//    }

    public Book(Long id, String name, String desc, Integer yearOfPublication, String bookType) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.yearOfPublication = yearOfPublication;
        this.bookType = bookType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(Integer yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                ", bookType='" + bookType + '\'' +
                '}';
    }
}
