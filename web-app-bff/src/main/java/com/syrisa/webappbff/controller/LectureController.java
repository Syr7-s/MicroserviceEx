package com.syrisa.webappbff.controller;


import com.syrisa.webappbff.dto.LectureDto;
import com.syrisa.webappbff.entity.Lecture;
import com.syrisa.webappbff.service.LectureService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class LectureController {
    private final LectureService lectureService;

    public LectureController(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    @PostMapping("/lecture")
    public LectureDto create(@RequestBody LectureDto lectureDto) {
        try {
            return lectureService.create(lectureDto.toLecture()).toLectureDto();
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }

    @GetMapping("/lecture/{lectureCode}")
    public LectureDto getLectureByLectureCode(@PathVariable("lectureCode") String lectureCode) {
        try {
            return lectureService.getLectureByLectureCode(lectureCode).toLectureDto();
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }

    @GetMapping(value = "/books", params = {"page", "size"})
    public List<LectureDto> getAllLecture(@Min(0) int page, @Min(1) int size) {
        return lectureService.getAll(page, size).stream()
                .map(Lecture::toLectureDto)
                .collect(Collectors.toList());

    }
}
