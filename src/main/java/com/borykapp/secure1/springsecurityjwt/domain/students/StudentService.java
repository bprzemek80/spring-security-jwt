package com.borykapp.secure1.springsecurityjwt.domain.students;

import com.borykapp.secure1.springsecurityjwt.domain.quote.QuoteService;
import com.borykapp.secure1.springsecurityjwt.domain.quote.model.Quote;
import com.borykapp.secure1.springsecurityjwt.domain.students.exception.StudentNotFoundException;
import com.borykapp.secure1.springsecurityjwt.domain.students.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class StudentService {

    private static List<Student> inMemoryDatabase = new ArrayList<>();

    static {
        inMemoryDatabase.add(Student.create(1L, "John", "Abcds"));
        inMemoryDatabase.add(Student.create(2L, "Adam", "Deer"));
        inMemoryDatabase.add(Student.create(3L, "Mickey", "Lion"));
        inMemoryDatabase.add(Student.create(4L, "Gregory", "Elephant"));
        inMemoryDatabase.add(Student.create(5L, "Johny", "Gazel"));
        inMemoryDatabase.add(Student.create(6L, "John", "Squirrel"));
        inMemoryDatabase.add(Student.create(7L, "Mickey", "Deer"));
    }

    public List<Student> getAllStudents() {
        return inMemoryDatabase;
    }

    public Student getStudentById(Long id) {
        return inMemoryDatabase.stream()
                .filter(byId(id))
                .findFirst()
                .orElseThrow(createStudentNotFoundException(id));
    }

    private static Supplier<StudentNotFoundException> createStudentNotFoundException(Long id) {
        return () -> new StudentNotFoundException(format("Can't find student by id [%d]", id));
    }

    private static Predicate<Student> byId(Long id) {
        return s -> s.getStudentId().equals(id);
    }
}
