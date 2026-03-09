package com.university.course.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.university.course.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    List<Course> findByTitleContainingIgnoreCase(String title);

}