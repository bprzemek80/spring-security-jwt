package com.borykapp.secure1.springsecurityjwt.domain.subjects;

import com.borykapp.secure1.springsecurityjwt.domain.subjects.model.Subject;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }
}
