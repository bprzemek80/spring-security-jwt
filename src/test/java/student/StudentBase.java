package student;

import com.borykapp.secure1.springsecurityjwt.domain.students.StudentsService;
import com.borykapp.secure1.springsecurityjwt.domain.students.model.Student;
import com.borykapp.secure1.springsecurityjwt.rest.StudentsController;
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
    StudentsService studentsService;

    @Before
    public void setup() {
        stubForGetAllStudents();
        stubForGetStudentById();

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(studentsController).build();
        RestAssuredMockMvc.mockMvc(mockMvc);
    }

    private void stubForGetStudentById() {
        when(studentsService.getStudentById(any()))
                .thenReturn(new Student(1L, "John", "Banana"));
    }

    public void stubForGetAllStudents() {
        when(studentsService.getAllStudents())
                .thenReturn(createStudentList());
    }

    private List<Student> createStudentList() {
        List<Student> list = new ArrayList<>();

        list.add(new Student(1L, "John", "Squirrel"));
        list.add(new Student(2L, "Adam", "Bear"));

        return list;
    }
}
