package com.syrisa.studentservice.controller;

import com.syrisa.studentservice.dto.StudentDto;
import com.syrisa.studentservice.entity.Student;
import com.syrisa.studentservice.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
    private final StudentService<Student> studentService;

    public StudentController(StudentService<Student> studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public StudentDto create(@RequestBody StudentDto studentDto){
        try{
            return studentService.create(studentDto.toStudent()).toStudentDto();
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        }
    }

}
