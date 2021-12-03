package com.syrisa.webappbff.client;

import com.syrisa.webappbff.dto.StudentDto;
import com.syrisa.webappbff.entity.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;

@FeignClient("student-service")
public interface StudentServiceClient {
    @PostMapping("/api/v1/student/create")
    StudentDto create(@RequestBody StudentDto studentDto);

    @PutMapping("/api/v1/student/edit")
    StudentDto update(@RequestBody StudentDto studentDto);

    @GetMapping("/api/v1/student/id/{id}")
    Student getByID(@PathVariable("id") Long id);

    @GetMapping("/api/v1/student/studentNumber/{studentNumber}")
    StudentDto getByStudentNumber(@PathVariable("studentNumber") Long studentNumber);



    @DeleteMapping("/api/v1/student/undo/{id}")
    String delete(@PathVariable("id") Long id);


}
