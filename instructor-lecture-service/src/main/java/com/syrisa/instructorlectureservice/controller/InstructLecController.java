package com.syrisa.instructorlectureservice.controller;

import com.syrisa.instructorlectureservice.dto.InstructorLecDto;
import com.syrisa.instructorlectureservice.service.InstructorLecService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1")
public class InstructLecController {
    private final InstructorLecService instructorLecService;

    public InstructLecController(InstructorLecService instructorLecService) {
        this.instructorLecService = instructorLecService;
    }

    @PostMapping("/instructorlec")
    @ResponseStatus(HttpStatus.OK)
    public InstructorLecDto create(@RequestBody InstructorLecDto instructorLecDto){
        try{
            return instructorLecService.create(instructorLecDto.toInstructorLec()).toInstructorLecDto();
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        }
    }
}
