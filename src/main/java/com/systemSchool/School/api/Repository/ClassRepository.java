package com.systemSchool.School.api.Repository;

import com.systemSchool.School.api.Model.ClassAPI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassRepository extends JpaRepository<ClassAPI,Long> {
    Optional<ClassAPI> findByClassName(String className);
}
