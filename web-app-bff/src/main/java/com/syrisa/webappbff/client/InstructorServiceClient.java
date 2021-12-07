package com.syrisa.webappbff.client;

import com.syrisa.webappbff.dto.InstructorDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;

@FeignClient("instructor-service")
public interface InstructorServiceClient {
    @PostMapping("/api/v1/instructor/create")
    InstructorDto create(@RequestBody InstructorDto instructorDto);

    @PutMapping("api/v1/instructor/edit")
    InstructorDto update(@RequestBody InstructorDto instructorDto);

    @GetMapping("api/v1/instructor/{id}")
    InstructorDto getById(@PathVariable("id") Long id);

    @GetMapping(value = "/lectures", params = {"page", "size"})
    List<InstructorDto> getAll(@Min(0) int page, @Min(1) int size);

    @DeleteMapping("api/v1/instructor/undo/{id}")
    String delete(@PathVariable("id") Long id);
}
