package com.example.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.student.exception.InvalidInputException;
import com.example.student.model.Student;
import com.example.student.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable String id) {

        int studentId;

        try {
            studentId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Student ID must be numeric");
        }

        return studentService.getStudentById(studentId);
    }
}