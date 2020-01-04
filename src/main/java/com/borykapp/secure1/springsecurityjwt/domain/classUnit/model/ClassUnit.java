package com.borykapp.secure1.springsecurityjwt.domain.classUnit.model;

import com.borykapp.secure1.springsecurityjwt.domain.students.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ClassUnit {
    private Long id;
    private String name;
    private List<Student> studentList;
}
