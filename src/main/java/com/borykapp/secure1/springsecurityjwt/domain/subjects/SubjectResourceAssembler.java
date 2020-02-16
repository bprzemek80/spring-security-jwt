package com.borykapp.secure1.springsecurityjwt.domain.subjects;

import com.borykapp.secure1.springsecurityjwt.domain.subjects.model.Subject;
import com.borykapp.secure1.springsecurityjwt.rest.dto.SubjectResource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SubjectResourceAssembler implements Converter<Subject, SubjectResource> {
    @Override
    public SubjectResource convert(Subject source) {
        return new SubjectResource(
                source.getId(),
                source.getName());
    }
}
