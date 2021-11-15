package com.syrisa.instructorservice.client;

import com.syrisa.instructorservice.entity.impl.Lecture;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("lecture-service")
public interface LectureProcessClient {
    @GetMapping("/api/v1/lecture/{lectureCode}")
    Lecture getLectureCode(@PathVariable("lectureCode") String lectureCode);
}
