package com.example.Student_App.controller;

import com.example.Student_App.controller.request.StudentRequest;
import com.example.Student_App.controller.response.MessageResponse;
import com.example.Student_App.controller.response.StudentResponse;
import com.example.Student_App.model.Student;
import com.example.Student_App.repository.StudentRepository;
import com.example.Student_App.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
public class StudentController {

    private StudentService studentService;

    @PostMapping("/students")
    public StudentResponse studentAdd(@RequestBody StudentRequest request){

        return studentService.add(request);

    }

    @GetMapping("/students")
    public List<StudentResponse> getStudents(){

        return studentService.allStudentts();

    }

    @DeleteMapping("/students/{id}")
    public MessageResponse studentDelete(@PathVariable Long id){

        return studentService.delete(id);
    }

    @PutMapping("/students/{id}")
    public StudentResponse studentUpdate(@PathVariable Long id ,@RequestBody StudentRequest request){
        return studentService.update(id,request);
    }

    @GetMapping("/students/{id}")
    public StudentResponse studentView(@PathVariable Long id ){
        return studentService.view(id);
    }


}


