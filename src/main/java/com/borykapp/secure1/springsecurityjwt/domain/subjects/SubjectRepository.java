package com.borykapp.secure1.springsecurityjwt.domain.subjects;

import com.borykapp.secure1.springsecurityjwt.domain.subjects.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
