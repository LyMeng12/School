package com.systemSchool.School.api.Repository;

import com.systemSchool.School.api.Model.StudentAPI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentAPI,Long> {
    Optional<StudentAPI> findByStudentName(String studentName);
}
