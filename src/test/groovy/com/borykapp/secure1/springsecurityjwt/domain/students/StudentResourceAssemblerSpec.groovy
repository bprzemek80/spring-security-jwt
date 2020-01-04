package com.borykapp.secure1.springsecurityjwt.domain.students

import com.borykapp.secure1.springsecurityjwt.domain.students.model.Student
import spock.lang.Specification

class StudentResourceAssemblerSpec extends Specification {

    StudentResourceAssembler resourceAssembler = new StudentResourceAssembler()

    def "should convert student to rest resource"() {
        given:
            def student = new Student(1L, "John", "Banana")
        when:
            def result = resourceAssembler.convert(student)
        then:
            result.getId() == student.getStudentId()
            result.getFirstName() == student.getFirstName()
            result.getLastName() == student.getLastName()

    }
}
