package com.university.course.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.university.course.model.Course;
import com.university.course.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService service;

    @PostMapping("/add")
    public ResponseEntity<?> addCourse(@RequestBody Course course) {
        try {
            Course c = service.addCourse(course);
            return new ResponseEntity<>(c, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Course creation failed", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return new ResponseEntity<>(service.getAllCourses(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourse(@PathVariable int id) {
        Optional<Course> course = service.getCourseById(id);

        if(course.isPresent())
            return new ResponseEntity<>(course.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable int id, @RequestBody Course course) {

        Optional<Course> existing = service.getCourseById(id);

        if(existing.isPresent()) {
            return new ResponseEntity<>(service.updateCourse(id, course), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable int id) {

        Optional<Course> existing = service.getCourseById(id);

        if(existing.isPresent()) {
            service.deleteCourse(id);
            return new ResponseEntity<>("Course deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search/{title}")
    public ResponseEntity<?> searchCourse(@PathVariable String title) {

        List<Course> courses = service.searchByTitle(title);

        if(courses.isEmpty())
            return new ResponseEntity<>("No courses found", HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(courses, HttpStatus.OK);
    }
}