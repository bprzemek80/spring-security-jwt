package com.borykapp.secure1.springsecurityjwt.domain.quote.exception;

public class QuoteNotFoundException extends RuntimeException {
    public QuoteNotFoundException(String message) {
        super(message);
    }
}
