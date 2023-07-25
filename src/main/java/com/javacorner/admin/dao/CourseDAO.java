package com.javacorner.admin.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.javacorner.admin.entity.Course;

public interface CourseDAO extends JpaRepository<Course, Long> {
    List<Course> findByCoursesByCourseNameContains(String keyword);

    @Query(value = "select * from tb_courses as c where c.course_id in (select e.course_id from enrolled_in as e where e.student_id=:studentId) ", nativeQuery = true)
    List<Course> getCoursesByStudentId(@Param("studentId") Long studentId);
}