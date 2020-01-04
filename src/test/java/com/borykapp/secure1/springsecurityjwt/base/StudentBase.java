package com.borykapp.secure1.springsecurityjwt.base;

import com.borykapp.secure1.springsecurityjwt.domain.students.StudentResourceService;
import com.borykapp.secure1.springsecurityjwt.domain.students.model.Student;
import com.borykapp.secure1.springsecurityjwt.rest.StudentsController;
import com.borykapp.secure1.springsecurityjwt.rest.dto.QuoteStudentResource;
import com.borykapp.secure1.springsecurityjwt.rest.dto.StudentResource;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public abstract class StudentBase {
    @InjectMocks
    StudentsController studentsController;

    @Mock
    StudentResourceService studentResourceService;

    @Before
    public void setup() {
        stubForGetAllStudents();
        stubForGetStudentById();
        stubForGetQuoteForStudentById();

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(studentsController).build();
        RestAssuredMockMvc.mockMvc(mockMvc);
    }

    private void stubForGetQuoteForStudentById() {
        when(studentResourceService.getQuoteByStudentId(any()))
                .thenReturn(new QuoteStudentResource("Type1", "Sample quote", 1, new Student(1L, "John", "Banana")));
    }

    private void stubForGetStudentById() {
        when(studentResourceService.getStudentById(any()))
                .thenReturn(new StudentResource(1L, "John", "Banana"));
    }

    public void stubForGetAllStudents() {
        when(studentResourceService.getAllStudents())
                .thenReturn(createStudentList());
    }

    private List<StudentResource> createStudentList() {
        List<StudentResource> list = new ArrayList<>();

        list.add(new StudentResource(1L, "John", "Squirrel"));
        list.add(new StudentResource(2L, "Adam", "Bear"));

        return list;
    }
}
