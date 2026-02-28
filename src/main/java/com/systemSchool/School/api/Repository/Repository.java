package com.systemSchool.School.api.Repository;

import com.systemSchool.School.api.Entity.student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@org.springframework.stereotype.Repository
public interface Repository extends CrudRepository<student,Long> {
//    Optional<student> findById(Long id);
}
