package com.systemSchool.School.api.Repository;


import com.systemSchool.School.api.Entitty.ClassAPI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassAPIRepository extends JpaRepository<ClassAPI, Long> {
}
