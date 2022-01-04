package com.syrisa.webappbff.client;

import com.syrisa.webappbff.dto.InstructorLecDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;

@FeignClient("instructor-lecture-service")
public interface InstructorLecServiceClient {
    @PostMapping("/api/v1/instructorLec")
    InstructorLecDto create(@RequestBody InstructorLecDto instructorLecDto);

    @PutMapping("/api/v1/instructorLec/add/students/{instructorLecID}")
    InstructorLecDto addStudent(@PathVariable("instructorLecID") Long instructorLecID);

    @GetMapping("/api/v1/instructorLec/{id}")
    InstructorLecDto getByID(@PathVariable("id") Long id);

    @GetMapping("/api/v1/inscturctorLec/lectureCode/{lectureCode}")
    InstructorLecDto getLectureCode(@PathVariable("lectureCode") String lectureCode);

    @GetMapping(value = "/api/v1/inscturctorLec/allReg",params = {"page", "size"})
    List<InstructorLecDto> getAll(@Min(0) int page, @Min(1) int size);

    @DeleteMapping("/api/v/inscturctorLec/undo/{id}")
    String delete(@PathVariable("id") Long id);

}
