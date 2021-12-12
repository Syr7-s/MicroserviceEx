package com.syrisa.webappbff.client;

import com.syrisa.webappbff.dto.InstructorLecDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("instructor-lecture-service")
public interface InstructorLecServiceClient {
    @PostMapping("/api/v1/instructorLec")
    InstructorLecDto create(@RequestBody InstructorLecDto instructorLecDto);


}
