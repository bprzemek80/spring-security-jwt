package com.borykapp.secure1.springsecurityjwt.rest;

import com.borykapp.secure1.springsecurityjwt.security.exception.SSUserNotFoundException;
import com.borykapp.secure1.springsecurityjwt.security.exception.SSWrongCredentialException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HelloWorldExceptionController {
    @ExceptionHandler(value = SSUserNotFoundException.class)
    public ResponseEntity<Object> exception(SSUserNotFoundException e) {
        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = SSWrongCredentialException.class)
    public ResponseEntity<Object> exception(SSWrongCredentialException e) {
        return new ResponseEntity<>("Wrong password or username", HttpStatus.NOT_FOUND);
    }
}
