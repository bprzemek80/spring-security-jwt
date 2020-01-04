package com.borykapp.secure1.springsecurityjwt.domain.classUnit

import com.borykapp.secure1.springsecurityjwt.domain.classUnit.model.ClassUnit
import com.borykapp.secure1.springsecurityjwt.domain.students.model.Student
import spock.lang.Specification

class ClassUnitResourceAssemblerSpec extends Specification {

    ClassUnitResourceAssembler classUnitResourceAssembler = new ClassUnitResourceAssembler()

    def "should convert class unit to rest resource"() {
        given:
            def classUnit = new ClassUnit(1L, "Lion's", List.of(Student.create(1L, "John", "Banana")))
        when:
            def result = classUnitResourceAssembler.convert(classUnit)
        then:
            result.getId() == classUnit.getId()
            result.getName() == classUnit.getName()
            result.getStudentList() == classUnit.getStudentList()
    }
}
