package com.example.student.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.student.exception.StudentNotFoundException;
import com.example.student.model.Student;

@Service
public class StudentService {

    private static Map<Integer, Student> students = new HashMap<>();

    static {
        students.put(1, new Student(1, "Rahul", "CSE"));
        students.put(2, new Student(2, "Anita", "ECE"));
        students.put(3, new Student(3, "Kiran", "IT"));
    }

    public Student getStudentById(int id) {

        if(!students.containsKey(id)) {
            throw new StudentNotFoundException("Student with ID " + id + " not found");
        }

        return students.get(id);
    }
}