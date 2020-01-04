package com.borykapp.secure1.springsecurityjwt.rest.dto;

import com.borykapp.secure1.springsecurityjwt.domain.students.model.Student;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class QuoteStudentResource {
    private String type;
    private String quote;
    private Integer quoteId;
    private Student student;
}
