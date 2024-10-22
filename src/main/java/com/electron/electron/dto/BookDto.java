package com.electron.electron.dto;

import com.electron.electron.entity.Author;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

public class BookDto {

    private Long id;
    private String name;
    private String desc;
    private Integer yearOfPublication;
    private String bookType;

    private List<AuthorDto>authors;

    public BookDto() {
    }

    public BookDto(Long id, String name, String desc, Integer yearOfPublication, String bookType, List<AuthorDto> authors) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.yearOfPublication = yearOfPublication;
        this.bookType = bookType;
        this.authors = authors;
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

    public List<AuthorDto> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorDto> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                ", bookType='" + bookType + '\'' +
                ", authors=" + authors +
                '}';
    }
}
