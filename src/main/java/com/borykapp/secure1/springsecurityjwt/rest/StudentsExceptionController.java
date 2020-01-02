package com.borykapp.secure1.springsecurityjwt.rest;

import com.borykapp.secure1.springsecurityjwt.domain.students.exception.QuoteNotFoundException;
import com.borykapp.secure1.springsecurityjwt.domain.students.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentsExceptionController {
    @ExceptionHandler(value = StudentNotFoundException.class)
    public ResponseEntity<Object> exception(StudentNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = QuoteNotFoundException.class)
    public ResponseEntity<Object> exception(QuoteNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
