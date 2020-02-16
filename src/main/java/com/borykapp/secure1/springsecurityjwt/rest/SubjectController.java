package com.borykapp.secure1.springsecurityjwt.rest;

import com.borykapp.secure1.springsecurityjwt.domain.subjects.SubjectResourceService;
import com.borykapp.secure1.springsecurityjwt.rest.dto.SubjectResource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestV1Controller
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectResourceService subjectResourceService;

    @GetMapping("/subjects")
    public List<SubjectResource> getAllSubjects() {
        return subjectResourceService.getAllSubjects();
    }
}
