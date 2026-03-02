package com.systemSchool.School.api.Repository;

import com.systemSchool.School.api.Entity.StudentAPI;
import com.systemSchool.School.api.Entity.SubjectAPI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectAPI,Long> {
}
