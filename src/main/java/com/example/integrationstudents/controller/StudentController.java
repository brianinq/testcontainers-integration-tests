package com.example.integrationstudents.controller;

import com.example.integrationstudents.entity.Student;
import com.example.integrationstudents.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @GetMapping
    List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
}
