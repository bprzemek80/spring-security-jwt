package com.borykapp.secure1.springsecurityjwt.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class StudentResource {
    private Long id;
    private String firstName;
    private String lastName;
}
