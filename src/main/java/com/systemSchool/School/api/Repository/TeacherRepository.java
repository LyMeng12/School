package com.systemSchool.School.api.Repository;

import com.systemSchool.School.api.Entitty.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
