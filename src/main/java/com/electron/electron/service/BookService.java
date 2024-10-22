package com.electron.electron.service;

import com.electron.electron.Data.BookData;
import com.electron.electron.Exception.BadRequestException;
import com.electron.electron.common.CommonResponse;
import com.electron.electron.common.Error;
import com.electron.electron.dto.AuthorDto;
import com.electron.electron.dto.BookDto;
import com.electron.electron.entity.Author;
import com.electron.electron.entity.Book;
import com.electron.electron.entity.BookAuthor;
import com.electron.electron.repository.BookAuthorRepository;
import com.electron.electron.repository.BookRepository;
import com.electron.electron.validator.BookValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookAuthorRepository bookAuthorRepository;
    @Autowired
    BookValidator bookValidator;


//    static  List<Book>bookList = Arrays.asList(new Book(1, "Effective Java", "A comprehensive guide to best practices in Java programming.", "Programming"),
//            new Book(2, "Clean Code", "A handbook of agile software craftsmanship.", "Programming"),
//            new Book(3, "The Pragmatic Programmer", "Your journey to mastery in software development.", "Programming"));


    public CommonResponse getBooks(){
        CommonResponse commonResponse = new CommonResponse();
        List<Book>bookList = new ArrayList<>();
        bookRepository.findAll().forEach(book -> bookList.add(book));

//        Map data = new HashMap();
//        data.put("books", bookList);

        BookData bookData = new BookData();
        bookData.setBooks(bookList);
        commonResponse.setData(bookData);

//        return bookList;
        return commonResponse;
    }

    public Book createBook(Book book) {
        //validate
       List<Error> errors = bookValidator.validateCreateBookRequest(book);
            if(!errors.isEmpty()){
                throw new BadRequestException("Bad Request",errors);
            }
        return bookRepository.save(book);
    }

    public BookDto getBookById(Long bookId, boolean authorData) {
        BookDto bookDto = new BookDto();
        Book book = bookRepository.findById(bookId).orElse(null);

        if (book == null) {
            // Handle book not found case here (optional)
            return null;
        }

        // Populate basic book information
        bookDto.setId(book.getId());
        bookDto.setName(book.getName());
        bookDto.setDesc(book.getDesc());
        bookDto.setYearOfPublication(book.getYearOfPublication());
        bookDto.setBookType(book.getBookType());

        if (authorData) {
            // Fetch authors if authorData is true
            List<BookAuthor> bookAuthors = bookAuthorRepository.findAllByBookId(bookId);
            List<AuthorDto> authorDtoList = new ArrayList<>();

            if (bookAuthors != null) {
                for (BookAuthor bookAuthor : bookAuthors) {
                    AuthorDto authorDto = new AuthorDto();
                    Author author = bookAuthor.getAuthor();

                    authorDto.setId(author.getId());
                    authorDto.setName(author.getName());
                    authorDto.setGender(author.getGender());
                    authorDtoList.add(authorDto);
                }
                bookDto.setAuthors(authorDtoList);
            }
        }

        return bookDto;
    }


    public CommonResponse updateBook(Book book) {
        CommonResponse commonResponse = new CommonResponse();
        book = bookRepository.save(book);
//        commonResponse.setData(bookRepository.save(book));
//        return bookRepository.save(book);

        BookData bookData = new BookData();
        bookData.setBook(book);
        commonResponse.setData(bookData);
        return commonResponse;
    }

    public String deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
        return  "Deleted Successfully";
    }

    public CommonResponse getCaughtExeption(Integer number) {

        System.out.println(number);
        CommonResponse commonResponse = new CommonResponse();
        int result = 100/number;

        commonResponse.setData(result);
        return commonResponse;
    }
}
