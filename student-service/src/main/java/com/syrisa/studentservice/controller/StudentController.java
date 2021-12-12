package com.syrisa.studentservice.controller;

import com.syrisa.studentservice.dto.StudentDto;
import com.syrisa.studentservice.entity.Student;
import com.syrisa.studentservice.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/create")
    public StudentDto create(@RequestBody StudentDto studentDto){
        try{
            return studentService.create(studentDto.toStudent()).toStudentDto();
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        }
    }

    @PutMapping("/edit")
    public StudentDto update(@RequestBody StudentDto studentDto){
        try {
            return studentService.update(studentDto.toStudent()).toStudentDto();
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        }
    }

    @GetMapping("/id/{id}")
    public StudentDto getByID(@PathVariable("id") Long id){
        try {
            return studentService.getByID(id).toStudentDto();
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        }
    }

    @GetMapping(value = "/students",params = {"page", "size"})
    public List<StudentDto> getStudents(@Min(0) int page, @Min(1) int size){
        return studentService.getAll(PageRequest.of(page, size))
                .stream()
                .map(Student::toStudentDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/undo/{id}")
    public String delete(@PathVariable("id") Long id){
        try{
            return studentService.delete(id);
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        }
    }

    @GetMapping("/studentNumber/{studentNumber}")
    public StudentDto getByStudentNumber(@PathVariable("studentNumber") Long studentNumber){
        try{
            return studentService.findStudentByStudentNumber(studentNumber).toStudentDto();
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        }
    }

}
