package com.syrisa.studentlectureservice.controller;

import com.syrisa.studentlectureservice.dto.StudentLectureDto;
import com.syrisa.studentlectureservice.entity.impl.StudentLecture;
import com.syrisa.studentlectureservice.service.StudentLectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/studentLecture")
public class StudentLectureController {

    private final StudentLectureService studentLectureService;

    @PostMapping("/create")
    public StudentLectureDto create(@RequestBody StudentLectureDto studentLectureDto){
        try{
            return studentLectureService.create(studentLectureDto.toStudentLecture()).toStudentLectureDto();
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        }
    }

    @PutMapping("/update")
    public StudentLectureDto update(@RequestBody StudentLectureDto studentLectureDto){
        try{
            return studentLectureService.update(studentLectureDto.toStudentLecture()).toStudentLectureDto();
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        }
    }

    @GetMapping("/get/{id}")
    public StudentLectureDto getByID(@PathVariable("id") Long id){
        try{
            return studentLectureService.getByID(id).toStudentLectureDto();
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        }
    }

    @GetMapping(value = "/all",params = {"page","size"})
    public List<StudentLectureDto> getAll(@Min(0) int page, @Min(1) int size){
        return studentLectureService.getAll(PageRequest.of(page, size))
                .stream()
                .map(StudentLecture::toStudentLectureDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/studentNum/{studentNumber}")
    public StudentLectureDto findStudentLectureByStudentNumber(@PathVariable("studentNumber") Long studentNumber){
        try{
            return studentLectureService.findStudentLectureByStudentNumber(studentNumber).toStudentLectureDto();
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        }
    }

    @DeleteMapping("/undo/id")
    public String delete(@PathVariable("id") Long id){
        try{
            return studentLectureService.delete(id);
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        }
    }
}
