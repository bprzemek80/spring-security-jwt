package com.borykapp.secure1.springsecurityjwt.domain.classUnit;

import com.borykapp.secure1.springsecurityjwt.domain.classUnit.model.ClassUnit;
import com.borykapp.secure1.springsecurityjwt.rest.dto.ClassUnitResource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ClassUnitResourceAssembler implements Converter<ClassUnit, ClassUnitResource> {
    @Override
    public ClassUnitResource convert(ClassUnit source) {
        return new ClassUnitResource(
                source.getId(),
                source.getName(),
                source.getStudentList());
    }
}
