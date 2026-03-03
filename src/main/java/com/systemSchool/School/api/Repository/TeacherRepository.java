package com.systemSchool.School.api.Repository;

import com.systemSchool.School.api.Entity.StudentAPI;
import com.systemSchool.School.api.Entity.SubjectAPI;
import com.systemSchool.School.api.Entity.TeacherAPI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherAPI,Long> {
}
