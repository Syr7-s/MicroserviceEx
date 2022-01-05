package com.syrisa.webappbff.controller;

import com.syrisa.webappbff.dto.InstructorLecDto;
import com.syrisa.webappbff.entity.InstructorLec;
import com.syrisa.webappbff.service.InstructorLecService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/instructorLec")
public class InstructorLecController {
    private final InstructorLecService instructorLecService;

    @PostMapping("/create")
    public InstructorLecDto create(@RequestBody InstructorLecDto instructorLecDto){
        try{
            return instructorLecService.create(instructorLecDto.toInstructorLec()).toInstructorLecDto();
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        }
    }

    @PutMapping("/update")
    public InstructorLecDto update(@RequestBody InstructorLecDto instructorLecDto){
        try{
            return instructorLecService.update(instructorLecDto.toInstructorLec()).toInstructorLecDto();
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        }
    }

    @GetMapping("/get/{id}")
    public InstructorLecDto getByID(@PathVariable("id") Long id){
        try{
            return instructorLecService.getById(id).toInstructorLecDto();
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        }
    }

    @GetMapping("/lecture/{lectureCode}")
    public InstructorLecDto getLectureCode(@PathVariable("lectureCode") String lectureCode){
        try{
            return instructorLecService.getByLectureCode(lectureCode).toInstructorLecDto();
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        }
    }

    @GetMapping(value = "/all",params = {"page", "size"})
    public List<InstructorLecDto> getAll(@Min(0) int page, @Min(1) int size){
        return instructorLecService.getAll(page, size)
                .stream()
                .map(InstructorLec::toInstructorLecDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/undo/{id}")
    public String delete(@PathVariable("id") Long id){
        try{
            return instructorLecService.delete(id);
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        }
    }
}
