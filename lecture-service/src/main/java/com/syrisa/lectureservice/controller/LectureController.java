package com.syrisa.lectureservice.controller;

import com.syrisa.lectureservice.dto.LectureDto;
import com.syrisa.lectureservice.entity.Lecture;
import com.syrisa.lectureservice.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class LectureController {
    private final LectureService<Lecture> lectureService;

    @PostMapping("/lecture")
    public LectureDto create(@RequestBody LectureDto lectureDto){
        try {
            return lectureService.create(lectureDto.toLecture()).toLectureDto();
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        }
    }

    @GetMapping("/lecture/{lectureCode}")
    public LectureDto getLectureByLectureCode(@PathVariable("lectureCode") String lectureCode){
        try{
            return lectureService.getLectureByLectureCode(lectureCode).toLectureDto();
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        }
    }

    @GetMapping(value = "/books", params = {"page", "size"})
    public List<LectureDto> getAllLecture(@Min(0) int page, @Min(1) int size){
        return lectureService.getAll(PageRequest.of(page, size))
                .stream()
                .map(Lecture::toLectureDto)
                .collect(Collectors.toList());
    }
}
