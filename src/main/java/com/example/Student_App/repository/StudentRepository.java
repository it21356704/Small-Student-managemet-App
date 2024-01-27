package com.example.Student_App.repository;

import com.example.Student_App.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface StudentRepository extends JpaRepository<Student,Long> {
}
