package com.electron.electron.Data;

import com.electron.electron.common.PaginationMeta;
import com.electron.electron.entity.Author;

import java.util.List;

public class AuthorData {
    private List<Author> authors;
    private PaginationMeta paginationMeta;

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public PaginationMeta getPaginationMeta() {
        return paginationMeta;
    }

    public void setPaginationMeta(PaginationMeta paginationMeta) {
        this.paginationMeta = paginationMeta;
    }
}
