package com.example.Student_App.service;

import com.example.Student_App.controller.request.StudentRequest;
import com.example.Student_App.controller.response.MessageResponse;
import com.example.Student_App.controller.response.StudentResponse;

import java.util.List;

public interface StudentService {

    StudentResponse add(StudentRequest request);

    List<StudentResponse> allStudentts();

    MessageResponse delete(Long id);

    StudentResponse update(Long id,StudentRequest request);

    StudentResponse view(Long id);
}
