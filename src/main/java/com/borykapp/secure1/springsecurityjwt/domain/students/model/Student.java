package com.borykapp.secure1.springsecurityjwt.domain.students.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Student implements Serializable {
    private Long studentId;
    private String firstName;
    private String lastName;

    public static Student createAdmissionStudent(Long id, String firstName, String lastName) {
        return new Student(id, firstName, lastName);
    }
}
