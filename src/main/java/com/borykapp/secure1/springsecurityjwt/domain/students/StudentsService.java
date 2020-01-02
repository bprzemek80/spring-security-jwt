package com.borykapp.secure1.springsecurityjwt.domain.students;

import com.borykapp.secure1.springsecurityjwt.domain.students.exception.StudentNotFoundException;
import com.borykapp.secure1.springsecurityjwt.domain.students.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.lang.String.format;

@Service
public class StudentsService {

    private static List<Student> inMemoryDatabase = new ArrayList<>();

    static {
        inMemoryDatabase.add(Student.createAdmissionStudent(1L, "John", "Abcds"));
        inMemoryDatabase.add(Student.createAdmissionStudent(2L, "Adam", "Deer"));
        inMemoryDatabase.add(Student.createAdmissionStudent(3L, "Mickey", "Lion"));
        inMemoryDatabase.add(Student.createAdmissionStudent(4L, "Gregory", "Elephant"));
        inMemoryDatabase.add(Student.createAdmissionStudent(5L, "Johny", "Gazel"));
        inMemoryDatabase.add(Student.createAdmissionStudent(6L, "John", "Squirrel"));
        inMemoryDatabase.add(Student.createAdmissionStudent(7L, "Mickey", "Deer"));
    }

    public List<Student> getAllStudents() {
        return inMemoryDatabase;
    }

    public Student getStudentById(Long id) {
        return inMemoryDatabase.stream()
                .filter(byId(id))
                .findFirst()
                .orElseThrow(() -> new StudentNotFoundException(format("Can't find student by id [%d]", id)));
    }

    private static Predicate<Student> byId(Long id) {
        return s -> s.getStudentId().equals(id);
    }
}
