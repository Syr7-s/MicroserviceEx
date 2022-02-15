package com.syrisa.webappbff.client;

import com.syrisa.webappbff.dto.StudentLectureDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("student-lecture-service")
public interface StudentLectureServiceClient {
    @PostMapping("/api/v1/student-lec/create")
    StudentLectureDto create(@RequestBody StudentLectureDto studentLectureDto);

    @PutMapping("/api/v1/student-lec/update")
    StudentLectureDto update(@RequestBody StudentLectureDto studentLectureDto);

    @GetMapping("/api/v1/student-lec/{id}")
    StudentLectureDto getById(@PathVariable("id") Long id);

    @GetMapping("/api/v1/student-lec/studentNumber/{studentNumber}")
    StudentLectureDto findStudentLectureByStudentNumber(@PathVariable("studentNumber") Long studentNumber);

    @DeleteMapping("/api/v1/student-lec/del/{id}")
    String delete(@PathVariable("id") Long id);

}
