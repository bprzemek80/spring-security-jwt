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

    static {
        inMemoryDatabase.add(
                new ClassUnit(1L, "Lion's",
                        List.of(
                                Student.create(1L, "John", "Banana"),
                                Student.create(2L, "Adam", "Citron"),
                                Student.create(3L, "William", "Honey"))));
        inMemoryDatabase.add(
                new ClassUnit(2L, "Crocodile's",
                        List.of(
                                Student.create(1L, "Albert", "Kiwi"),
                                Student.create(2L, "Laura", "Citron"),
                                Student.create(3L, "Pamela", "Strawberry"))));
    }

    public List<ClassUnit> getClassUnites() {
        return inMemoryDatabase;
    }
}
