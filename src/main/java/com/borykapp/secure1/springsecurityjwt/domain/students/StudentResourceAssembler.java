package com.borykapp.secure1.springsecurityjwt.domain.students;

import com.borykapp.secure1.springsecurityjwt.domain.students.model.Student;
import com.borykapp.secure1.springsecurityjwt.rest.dto.StudentResource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StudentResourceAssembler implements Converter<Student, StudentResource> {
    @Override
    public StudentResource convert(Student source) {
        return new StudentResource(
                source.getStudentId(),
                source.getFirstName(),
                source.getLastName()
        );
    }
}
