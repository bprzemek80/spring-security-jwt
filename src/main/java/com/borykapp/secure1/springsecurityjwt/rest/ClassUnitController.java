package com.borykapp.secure1.springsecurityjwt.rest;

import com.borykapp.secure1.springsecurityjwt.domain.classUnit.ClassUnitResourceService;
import com.borykapp.secure1.springsecurityjwt.rest.dto.ClassUnitResource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestV1Controller
@RequiredArgsConstructor
public class ClassUnitController {
    private final ClassUnitResourceService classUnitResourceService;

    @GetMapping("/class-unit")
    public List<ClassUnitResource> getClassUnitResources() {
        return classUnitResourceService.getClassUnitResources();
    }
}
