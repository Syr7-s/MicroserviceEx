package com.syrisa.studentservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("instructor-service")
public interface InstructorLecProcessClient {
    //@GetMapping("/api/v1//lectureCode/{lectureCode}")

}
