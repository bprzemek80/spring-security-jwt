package com.borykapp.secure1.springsecurityjwt.domain.students.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String message) {
        super(message);
    }
}
