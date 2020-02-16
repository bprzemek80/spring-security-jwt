package com.borykapp.secure1.springsecurityjwt;

import com.borykapp.secure1.springsecurityjwt.domain.students.StudentRepository;
import com.borykapp.secure1.springsecurityjwt.domain.students.model.Student;
import com.borykapp.secure1.springsecurityjwt.domain.subjects.SubjectRepository;
import com.borykapp.secure1.springsecurityjwt.domain.subjects.model.Subject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Stream;

@SpringBootApplication
@EnableConfigurationProperties

// This will allow to use scheduling process for the application
@EnableScheduling
public class SpringSecurityJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJwtApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }

    @Bean
    CommandLineRunner inMemoryDatabase(StudentRepository studentRepository, SubjectRepository subjectRepository) {
        return args -> {
            createStudents(studentRepository);
            createSubjects(subjectRepository);
        };
    }

    private void createSubjects(SubjectRepository subjectRepository) {
        Stream.of("History", "Mathematics", "Physics", "Computer Science")
                .forEach(subject -> subjectRepository.save(new Subject().setName(subject)));
    }

    private void createStudents(StudentRepository studentRepository) {
        Stream.of("John,Evans", "Maures,Edwards", "Anmend,Harper")
                .map(entry -> entry.split(","))
                .forEach(entryArray ->
                        studentRepository.save(Student.create(entryArray[0], entryArray[1])));
    }
}
