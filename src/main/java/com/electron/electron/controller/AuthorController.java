package com.electron.electron.controller;

import com.electron.electron.common.CommonResponse;
import com.electron.electron.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="tutorial/v1/author/")
public class AuthorController {

    @Autowired
    private AuthorService authorService;
    @GetMapping(path="/getAuthors")
    private CommonResponse getAuthors(Pageable pageable){
        CommonResponse commonResponse = authorService.getAuthors(pageable);

        return commonResponse;
    }
}
