package com.borykapp.secure1.springsecurityjwt.rest.dto;

import com.borykapp.secure1.springsecurityjwt.domain.students.model.Student;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.List;

@Value
@AllArgsConstructor
public class ClassUnitResource {
    private Long id;
    private String name;
    private List<Student> studentList;
}
