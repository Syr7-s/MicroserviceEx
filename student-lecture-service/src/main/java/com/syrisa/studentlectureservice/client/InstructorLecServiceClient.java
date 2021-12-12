package com.syrisa.studentlectureservice.client;

import com.syrisa.studentlectureservice.dto.InstructorLecDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient("instructor-lecture-service")
public interface InstructorLecServiceClient {
    @PutMapping("/api/v1/add/students/{instructorLecID}")
    InstructorLecDto addStudent(@PathVariable("instructorLecID") Long instructorLecID);
}
