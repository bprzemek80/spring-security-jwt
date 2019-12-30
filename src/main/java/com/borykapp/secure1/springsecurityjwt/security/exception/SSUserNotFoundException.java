package com.borykapp.secure1.springsecurityjwt.security.exception;

public class SSUserNotFoundException extends RuntimeException {
    public SSUserNotFoundException(String message) {
        super(message);
    }
}
