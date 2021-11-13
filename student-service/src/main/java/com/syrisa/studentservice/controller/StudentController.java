package com.syrisa.studentservice.controller;

import com.syrisa.studentservice.dto.StudentDto;
import com.syrisa.studentservice.entity.Student;
import com.syrisa.studentservice.mapper.StudentMapper;
import com.syrisa.studentservice.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
    private final StudentService<Student> studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public StudentDto create(@RequestBody StudentDto studentDto){
        try{
            return StudentMapper.INSTANCE.studentToStudentDto(studentService.create(StudentMapper.INSTANCE.studentDtoToStudent(studentDto)));
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        }
    }
}
