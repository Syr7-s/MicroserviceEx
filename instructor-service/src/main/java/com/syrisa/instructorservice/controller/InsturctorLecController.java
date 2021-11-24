package com.syrisa.instructorservice.controller;

import com.syrisa.instructorservice.dto.InstructorDto;
import com.syrisa.instructorservice.dto.InstructorLecDto;
import com.syrisa.instructorservice.entity.impl.Instructor;
import com.syrisa.instructorservice.entity.impl.InstructorLec;
import com.syrisa.instructorservice.service.InstructorLecService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class InsturctorLecController {
    private final InstructorLecService instructorLecService;

    public InsturctorLecController(InstructorLecService instructorLecService) {
        this.instructorLecService = instructorLecService;
    }

    @PostMapping("/instructor")
    public InstructorLecDto create(@RequestBody InstructorLecDto instructorLecDto) {
        try {
            return instructorLecService.create(instructorLecDto.toInstructorLec()).toInstructorLecDto();
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }

    @PutMapping("/edit")
    public InstructorLecDto update(@RequestBody InstructorLecDto instructorLecDto) {
        try {
            return instructorLecService.update(instructorLecDto.toInstructorLec()).toInstructorLecDto();
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }

    @GetMapping("/{id}")
    public InstructorLecDto getById(@PathVariable("id") Long id) {
        try {
            return instructorLecService.getByID(id).toInstructorLecDto();
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }

    @GetMapping(value = "/lectures", params = {"page", "size"})
    public List<InstructorLecDto> getAll(@Min(0) int page, @Min(1) int size) {
        return instructorLecService.getAll(PageRequest.of(page, size))
                .stream()
                .map(InstructorLec::toInstructorLecDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/undo/{id}")
    public String delete(@PathVariable("id") Long id){
        try {
            return instructorLecService.delete(id);
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }
}


