package com.borykapp.secure1.springsecurityjwt.domain.subjects;

import com.borykapp.secure1.springsecurityjwt.rest.dto.SubjectResource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class SubjectResourceService {

    private final SubjectService subjectService;
    private final SubjectResourceAssembler subjectResourceAssembler;

    public List<SubjectResource> getAllSubjects() {
        return subjectService.getAllSubjects()
                .stream()
                .map(subjectResourceAssembler::convert)
                .collect(toList());
    }
}
