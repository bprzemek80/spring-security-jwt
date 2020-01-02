package com.borykapp.secure1.springsecurityjwt.domain.students.exception;

public class QuoteNotFoundException extends RuntimeException {
    public QuoteNotFoundException(String message) {
        super(message);
    }
}
