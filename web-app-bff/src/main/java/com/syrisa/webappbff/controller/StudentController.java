package com.syrisa.webappbff.controller;

import com.syrisa.webappbff.dto.StudentDto;
import com.syrisa.webappbff.entity.Student;
import com.syrisa.webappbff.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public StudentDto create(@RequestBody StudentDto studentDto) {
        try {
            return studentService.create(studentDto.toStudent()).toStudentDto();
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }

    @PutMapping("/edit")
    public StudentDto update(@RequestBody StudentDto studentDto) {
        try {
            return studentService.update(studentDto.toStudent()).toStudentDto();
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }

    @GetMapping("/id/{id}")
    public StudentDto getByID(@PathVariable("id") Long id) {
        try {
            return studentService.getById(id).toStudentDto();
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }


    @DeleteMapping("/undo/{id}")
    public String delete(@PathVariable("id") Long id) {
        try {
            return studentService.delete(id);
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }

    @GetMapping("/studentNumber/{studentNumber}")
    public StudentDto getByStudentNumber(@PathVariable("studentNumber") Long studentNumber) {
        try {
            return studentService.findByStudentNumber(studentNumber).toStudentDto();
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }

}
