package com.electron.electron.validator;

import com.electron.electron.common.Error;
import com.electron.electron.entity.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookValidator {

    public List<Error> validateCreateBookRequest(Book book) {
        List<Error> errorList = new ArrayList<>();
            //name
        if(book.getName()==null){
            Error error = new Error("name","Book name is null");
            errorList.add(error);
        }
        if(book.getYearOfPublication()==null){
            Error error = new Error("YOB","year of publication is null");
            errorList.add(error);
        }
        if(book.getBookType()==null){
            Error error = new Error("bookType","book type is null");
            errorList.add(error);
        }
        return errorList;
    }
}
