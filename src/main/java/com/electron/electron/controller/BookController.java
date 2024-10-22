package com.electron.electron.controller;

import com.electron.electron.common.CommonResponse;
import com.electron.electron.dto.BookDto;
import com.electron.electron.entity.Book;
import com.electron.electron.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path="tutorial/v1/book/")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping(path="/getAllBooks")
    public CommonResponse getALlBooks(){
        return bookService.getBooks();
    }
    @PostMapping(path="/createMapping")
    public Book createBook(@RequestBody Book book){
        return bookService.createBook(book);
    }
    @GetMapping(path="/getBook/{id}")
    public BookDto getBookById(@PathVariable("id") Long bookId, @RequestParam(value="authorData",required = false)boolean authorData){
        System.out.println(bookId);
        System.out.println(authorData);
        return bookService.getBookById(bookId,authorData);
    }

    @PutMapping(path="/updateBook")
    public CommonResponse updateBook(@RequestBody Book book){
        return bookService.updateBook(book);
    }

    @DeleteMapping(path="/deleteBook/{bookId}")
    public String deleteBook(@PathVariable("bookId") Long bookId){
        return bookService.deleteBook(bookId);
    }

    @GetMapping(path="/getCaughtExeption")
    public CommonResponse getCaughtExeption(@RequestParam(value="number",required = false)Integer number){
        System.out.println(number);
        return bookService.getCaughtExeption(number);
    }
}
