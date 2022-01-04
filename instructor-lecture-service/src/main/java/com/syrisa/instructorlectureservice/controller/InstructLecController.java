package com.syrisa.instructorlectureservice.controller;

import com.syrisa.instructorlectureservice.dto.InstructorLecDto;
import com.syrisa.instructorlectureservice.entity.impl.InstructorLec;
import com.syrisa.instructorlectureservice.service.InstructorLecService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
public class InstructLecController {
    private final InstructorLecService instructorLecService;

    @PostMapping("/instructorLec")
    @ResponseStatus(HttpStatus.OK)
    public InstructorLecDto create(@RequestBody InstructorLecDto instructorLecDto){
        try{
            return instructorLecService.create(instructorLecDto.toInstructorLec()).toInstructorLecDto();
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        }
    }

    @PutMapping("/add/students/{instructorLecID}")
    public InstructorLecDto addStudent(@PathVariable("instructorLecID") Long instructorLecID){
        try{
            return instructorLecService.addStudent(instructorLecID).toInstructorLecDto();
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        }
    }

    @GetMapping("/inscturctorLec/{id}")
    public InstructorLecDto getByID(@PathVariable("id") Long id){
        try {
            return instructorLecService.getByID(id).toInstructorLecDto();
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        }
    }

    @GetMapping("/inscturctorLec/lectureCode/{lectureCode}")
    public InstructorLecDto getLectureCode(@PathVariable("lectureCode") String lectureCode){
        try {
            return instructorLecService.getByLectureCode(lectureCode).toInstructorLecDto();
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        }
    }

    @GetMapping(value = "/inscturctorLec/allReg",params = {"page", "size"})
    public List<InstructorLecDto> getAll(@Min(0) int page, @Min(1) int size){
        return instructorLecService.getAll(PageRequest.of(page, size))
                .stream()
                .map(InstructorLec::toInstructorLecDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/inscturctorLec/undo/{id}")
    public String delete(@PathVariable("id") Long id){
        try {
            return instructorLecService.delete(id);
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        }
    }

}
