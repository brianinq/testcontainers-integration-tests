package com.example.integrationstudents.service;

import com.example.integrationstudents.entity.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);
    List<Student> getAllStudents();
}
