package com.systemSchool.School.api.Repository;

import com.systemSchool.School.api.Entity.ClassAPI;
import com.systemSchool.School.api.Entity.StudentAPI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<ClassAPI,Long> {
}
