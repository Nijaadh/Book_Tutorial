package com.electron.electron.service;

import com.electron.electron.Data.AuthorData;
import com.electron.electron.common.CommonResponse;
import com.electron.electron.common.PaginationMeta;
import com.electron.electron.entity.Author;
import com.electron.electron.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;
    public CommonResponse getAuthors(Pageable pageable) {
        CommonResponse commonResponse = new CommonResponse();

        Page<Author> authorPage = authorRepository.findAll(pageable);
        List<Author> authors = authorPage.getContent();

        PaginationMeta authorPaginationMeta = PaginationMeta.createPagination(authorPage);

        AuthorData authorData = new AuthorData();

        authorData.setAuthors(authors);
        authorData.setPaginationMeta(authorPaginationMeta);

        commonResponse.setData(authorData);
        return commonResponse;
    }
}
