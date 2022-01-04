package com.syrisa.webappbff.client;

import com.syrisa.webappbff.dto.LectureDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;

@FeignClient("lecture-service")
public interface LectureServiceClient {
    @PostMapping("/api/v1/lecture")
    LectureDto create(@RequestBody LectureDto lectureDto);

    @PutMapping("lecture/update")
    LectureDto update(@RequestBody LectureDto lectureDto);

    @GetMapping("/lecture/{lectureCode}")
    LectureDto getLectureByLectureCode(@PathVariable("lectureCode") String lectureCode);

    @GetMapping(value = "/books", params = {"page", "size"})
    List<LectureDto> getAllLecture(@Min(0) int page, @Min(1) int size);

    @GetMapping("/api/v1/lecture/id/{lectureID}")
    LectureDto getByID(@PathVariable("lectureID") Integer lectureID);

    @DeleteMapping("/api/v1/lecture/lecture/undo/{lectureID}")
    String delete(@PathVariable("lectureID") Integer lecture);

}
