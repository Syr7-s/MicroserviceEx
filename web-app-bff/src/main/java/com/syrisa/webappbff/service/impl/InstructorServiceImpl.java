package com.syrisa.webappbff.service.impl;


import com.syrisa.webappbff.client.InstructorServiceClient;
import com.syrisa.webappbff.dto.InstructorDto;
import com.syrisa.webappbff.entity.Instructor;
import com.syrisa.webappbff.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {
    private final InstructorServiceClient instructorServiceClient;


    @Override
    public Instructor create(Instructor instructor) {
        try {
            return instructorServiceClient.create(instructor.toInstructorDto()).toInstructor();
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }

    }

    @Override
    public Instructor update(Instructor instructor) {
        try {
           return instructorServiceClient.update(instructor.toInstructorDto()).toInstructor();
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }


    @Override
    public List<Instructor> getAll(Pageable pageable) {
        return instructorServiceClient.getAll(pageable.getPageSize(), pageable.getPageNumber())
                .stream()
                .map(InstructorDto::toInstructor)
                .collect(Collectors.toList());
    }



    @Override
    public String delete(Long id) {
        try {
            return instructorServiceClient.delete(id);
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }

    @Override
    public Instructor getById(Long id) {
        return instructorServiceClient.getById(id).toInstructor();
    }
}
