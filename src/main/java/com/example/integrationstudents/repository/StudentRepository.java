package com.example.integrationstudents.repository;

import com.example.integrationstudents.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
