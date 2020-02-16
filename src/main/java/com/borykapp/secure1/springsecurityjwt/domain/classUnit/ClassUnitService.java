package com.borykapp.secure1.springsecurityjwt.domain.classUnit;

import com.borykapp.secure1.springsecurityjwt.domain.classUnit.model.ClassUnit;
import com.borykapp.secure1.springsecurityjwt.domain.students.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
/*
This is sample service implementation. Here should be written business logic. For this
example application will be used inMemoryDatabase.
 */
public class ClassUnitService {
    private static List<ClassUnit> inMemoryDatabase = new ArrayList<>();

    public List<ClassUnit> getClassUnites() {
        return inMemoryDatabase;
    }
}
