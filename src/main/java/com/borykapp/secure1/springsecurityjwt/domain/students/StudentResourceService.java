package com.borykapp.secure1.springsecurityjwt.domain.students;

import com.borykapp.secure1.springsecurityjwt.domain.quote.QuoteService;
import com.borykapp.secure1.springsecurityjwt.domain.quote.model.Quote;
import com.borykapp.secure1.springsecurityjwt.domain.students.model.Student;
import com.borykapp.secure1.springsecurityjwt.rest.dto.QuoteStudentResource;
import com.borykapp.secure1.springsecurityjwt.rest.dto.StudentResource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentResourceService {

    private final StudentService studentService;
    private final QuoteService quoteService;
    private final StudentResourceAssembler studentResourceAssembler;

    public List<StudentResource> getAllStudents() {
        return studentService.getAllStudents().stream()
                .map(studentResourceAssembler::convert)
                .collect(Collectors.toList());
    }

    public StudentResource getStudentById(Long id) {
        return studentResourceAssembler.convert(studentService.getStudentById(id));
    }

    public QuoteStudentResource getQuoteByStudentId(Long id) {
        Quote quote = quoteService.getQuote();
        Student student = studentService.getStudentById(id);
        return new QuoteStudentResource(
                quote.getType(),
                quote.getValue().getQuote(),
                quote.getValue().getId(),
                student
        );
    }
}
