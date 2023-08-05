package com.javacorner.admin.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.javacorner.admin.entity.Student;

public interface StudentDAO extends JpaRepository<Student, Long> {
    @Query(value = "select i from Student as i where i.firstName like %:name% or i.lastName like %:name%")
    List<Student> findStudentsByName(@Param("name") String name);

    @Query(value = "select i from Student as i where i.user.email=:email")
    Student findStudentByEmail(@Param("email") String email);
}
