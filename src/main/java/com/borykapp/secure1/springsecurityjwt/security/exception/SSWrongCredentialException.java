package com.borykapp.secure1.springsecurityjwt.security.exception;

public class SSWrongCredentialException extends RuntimeException {
    public SSWrongCredentialException(String message) {
        super(message);
    }
}
