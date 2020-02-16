package com.borykapp.secure1.springsecurityjwt.domain.students;

import com.borykapp.secure1.springsecurityjwt.domain.students.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
