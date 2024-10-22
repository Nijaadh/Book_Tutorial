package com.electron.electron.common;

import com.electron.electron.Exception.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobelExeptionHandler {

    @ExceptionHandler
    public ResponseEntity hadlerExeption(Exception e){
        CommonResponse commonResponse   = new CommonResponse();

        commonResponse.setError("Oops. something went wrong!");
        commonResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(commonResponse);
    }

    @ExceptionHandler
    public ResponseEntity handleBadRequestException(BadRequestException e){
        CommonResponse commonResponse   = new CommonResponse();

        commonResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        commonResponse.setError(e.getErrors());
        return ResponseEntity.status(400).body(commonResponse);
    }
}
