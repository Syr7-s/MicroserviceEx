package com.syrisa.studentservice.client;

import com.syrisa.studentservice.entity.impl.Entity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("instructor-service")
public interface InstructorLecProcessClient<T extends Entity> {
    @GetMapping("/api/v1//lectureCode/{lectureCode}")
    T getById(@PathVariable("lectureCode") String lectureCode);

}
