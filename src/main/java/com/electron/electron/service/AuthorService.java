package com.electron.electron.service;

import com.electron.electron.common.CommonResponse;
import com.electron.electron.entity.Author;
import com.electron.electron.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;
    public CommonResponse getAuthors(Pageable pageable) {
        CommonResponse commonResponse = new CommonResponse();

        Page<Author> authorPage = authorRepository.findAll(pageable);
        commonResponse.setData(authorPage);
        return commonResponse;
    }
}
