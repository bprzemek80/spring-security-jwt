package com.borykapp.secure1.springsecurityjwt.domain.classUnit;

import com.borykapp.secure1.springsecurityjwt.domain.classUnit.model.ClassUnit;
import com.borykapp.secure1.springsecurityjwt.rest.dto.ClassUnitResource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class ClassUnitResourceService {

    private final ClassUnitService classUnitService;
    private final ClassUnitResourceAssembler classUnitResourceAssembler;

    public List<ClassUnitResource> getClassUnitResources() {
        List<ClassUnit> classUnites = classUnitService.getClassUnites();
        return classUnites.stream()
                .map(classUnitResourceAssembler::convert)
                .collect(toList());
    }
}
