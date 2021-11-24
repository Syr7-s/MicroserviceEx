package com.syrisa.instructorservice.controller;

import com.syrisa.instructorservice.dto.InstructorDto;
import com.syrisa.instructorservice.entity.impl.Instructor;
import com.syrisa.instructorservice.service.InstructorService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/")
public class InstructorController {
    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @PostMapping("/instructor")
    public InstructorDto create(@RequestBody InstructorDto instructorDto) {
        try {
            return instructorService.create(instructorDto.toInstructor()).toInstructorDto();
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }

    @PutMapping("/edit")
    public InstructorDto update(@RequestBody InstructorDto instructorDto) {
        try {
            return instructorService.update(instructorDto.toInstructor()).toInstructorDto();
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }

    @GetMapping("/{id}")
    public InstructorDto getById(@PathVariable("id") Long id) {
        try {
            return instructorService.getByID(id).toInstructorDto();
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }

    @GetMapping(value = "/lectures", params = {"page", "size"})
    public List<InstructorDto> getAll(@Min(0) int page, @Min(1) int size) {
        return instructorService.getAll(PageRequest.of(page, size))
                .stream()
                .map(Instructor::toInstructorDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/undo/{id}")
    public String delete(@PathVariable("id") Long id){
        try {
            return instructorService.delete(id);
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }
}
