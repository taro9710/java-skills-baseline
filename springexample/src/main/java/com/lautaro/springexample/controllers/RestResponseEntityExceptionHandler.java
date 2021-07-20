package com.lautaro.springexample.controllers;

import com.lautaro.springexample.exceptions.ResourceNotFoundException;
import com.lautaro.springexample.exceptions.WebException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException(ResourceNotFoundException e, WebRequest request){
        return new ResponseEntity<>(e.getMessage(),new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({WebException.class})
    public ResponseEntity<Object> handleWebException(WebException e,WebRequest request){
        return new ResponseEntity<>(e.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

}
