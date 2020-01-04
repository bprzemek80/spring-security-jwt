package com.borykapp.secure1.springsecurityjwt.rest;

import com.borykapp.secure1.springsecurityjwt.domain.students.StudentResourceService;
import com.borykapp.secure1.springsecurityjwt.rest.dto.QuoteStudentResource;
import com.borykapp.secure1.springsecurityjwt.rest.dto.StudentResource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestV1Controller
@RequiredArgsConstructor
public class StudentsController {

    private final StudentResourceService studentResourceService;

    @GetMapping("/students")
    public List<StudentResource> getAllStudents() {
        return studentResourceService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public StudentResource getStudentById(@PathVariable Long id) {
        return studentResourceService.getStudentById(id);
    }

    @GetMapping("/students/{id}/quote")
    public QuoteStudentResource getStudentQuoteById(@PathVariable Long id) {
        return studentResourceService.getQuoteByStudentId(id);
    }

}
