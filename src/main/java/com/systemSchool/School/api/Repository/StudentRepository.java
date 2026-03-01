package com.systemSchool.School.api.Repository;

import com.systemSchool.School.api.Entitty.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
