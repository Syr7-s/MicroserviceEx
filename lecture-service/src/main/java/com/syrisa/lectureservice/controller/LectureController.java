package com.syrisa.lectureservice.controller;

import com.syrisa.lectureservice.dto.LectureDto;
import com.syrisa.lectureservice.entity.Lecture;
import com.syrisa.lectureservice.service.LectureService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1")
public class LectureController {
    private final LectureService<Lecture> lectureService;

    public LectureController(LectureService<Lecture> lectureService) {
        this.lectureService = lectureService;
    }

    @PostMapping("/lecture")
    public LectureDto create(@RequestBody LectureDto lectureDto){
        try {
            return lectureService.create(lectureDto.toLecture()).toLectureDto();
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        }
    }
}
