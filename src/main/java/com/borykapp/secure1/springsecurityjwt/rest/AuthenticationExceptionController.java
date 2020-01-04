package com.borykapp.secure1.springsecurityjwt.rest;

import com.borykapp.secure1.springsecurityjwt.security.exception.SecurityCredentialException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AuthenticationExceptionController {
    @ExceptionHandler(value = SecurityCredentialException.class)
    public ResponseEntity<Object> exception(SecurityCredentialException e) {
        return new ResponseEntity<>("Security exception has been thrown!", HttpStatus.NOT_FOUND);
    }
}
