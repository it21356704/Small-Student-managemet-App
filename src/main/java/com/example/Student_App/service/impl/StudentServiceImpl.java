package com.example.Student_App.service.impl;

import com.example.Student_App.controller.request.StudentRequest;
import com.example.Student_App.controller.response.MessageResponse;
import com.example.Student_App.controller.response.StudentResponse;
import com.example.Student_App.model.Student;
import com.example.Student_App.repository.StudentRepository;
import com.example.Student_App.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository repository;
    @Override
    public StudentResponse add(StudentRequest request) {

        Student student = new Student();
        student.setName(request.getName());
        student.setDegree(request.getDegree());
        repository.save(student);

        StudentResponse response = new StudentResponse();
        response.setName(student.getName());
        response.setDegree(student.getDegree());


        return response;
    }

    @Override
    public List<StudentResponse> allStudentts() {
        List<Student> AllStudent = repository.findAll();
        List<StudentResponse> studentResponseList = new ArrayList<>();

        for(Student student:AllStudent){
            StudentResponse studentResponse = new StudentResponse();
            studentResponse.setName(student.getName());
            studentResponse.setDegree(student.getDegree());
            studentResponseList.add(studentResponse);
        }

        return studentResponseList;
    }

    @Override
    public MessageResponse delete(Long id) {
        repository.deleteById(id);
        MessageResponse messageResponse = new MessageResponse();

        messageResponse.setMessage("Successful deleted"+id);

        return messageResponse;
    }

    @Override
    public StudentResponse update(Long id, StudentRequest request) {
        Optional<Student> studentOptional = repository.findById(id);
        if(studentOptional.isPresent()){
            Student student = studentOptional.get();
            student.setName(request.getName());
            student.setDegree(request.getDegree());

            Student updateStudent = repository.save(student);

            StudentResponse studentResponse= new StudentResponse();
            studentResponse.setName(updateStudent.getName());
            studentResponse.setDegree(updateStudent.getDegree());
            return studentResponse;
        }

        return null;
    }

    @Override
    public StudentResponse view(Long id) {

        Optional<Student> optionalStudent = repository.findById(id);
        StudentResponse studentResponse = new StudentResponse();

        if(optionalStudent.isPresent()){
            Student student = optionalStudent.get();

            studentResponse.setName(student.getName());
            studentResponse.setDegree(student.getDegree());

            return studentResponse;
        }

        return null;
    }
}

