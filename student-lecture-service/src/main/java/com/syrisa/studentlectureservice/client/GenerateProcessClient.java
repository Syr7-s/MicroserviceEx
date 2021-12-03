package com.syrisa.studentlectureservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("generate-service")
public interface GenerateProcessClient {
    @GetMapping("/api/v1/generate/{size}")
    String generateNumber(@PathVariable("size") int size);
}
