package com.borykapp.secure1.springsecurityjwt.domain.students;

import com.borykapp.secure1.springsecurityjwt.domain.students.exception.QuoteNotFoundException;
import com.borykapp.secure1.springsecurityjwt.domain.students.model.Quote;
import com.borykapp.secure1.springsecurityjwt.domain.students.exception.StudentNotFoundException;
import com.borykapp.secure1.springsecurityjwt.domain.students.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.lang.String.format;
import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class StudentsService {

    private final RestTemplate restTemplate;

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

    public Quote getStudentQuoteById(Long id) {
        Student student = inMemoryDatabase.stream()
                .filter(byId(id))
                .findFirst()
                .orElseThrow(() -> new StudentNotFoundException(format("Can't find quote for non existing student [%d]", id)));

        Quote quote = ofNullable(restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random", Quote.class))
                .orElseThrow(() -> new QuoteNotFoundException("Can't find quote for student!"));
        return quote.setStudent(student);
    }
}
