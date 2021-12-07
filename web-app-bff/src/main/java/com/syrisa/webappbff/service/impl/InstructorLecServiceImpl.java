package com.syrisa.webappbff.service.impl;

import com.syrisa.webappbff.client.InstructorLecServiceClient;
import com.syrisa.webappbff.entity.InstructorLec;
import com.syrisa.webappbff.service.InstructorLecService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class InstructorLecServiceImpl implements InstructorLecService {

    private final InstructorLecServiceClient instructorLecServiceClient;


    public InstructorLecServiceImpl(InstructorLecServiceClient instructorLecServiceClient) {
        this.instructorLecServiceClient = instructorLecServiceClient;

    }

    @Override
    public InstructorLec getByLectureCode(String lectureCode) {
        return null;
    }

    @Override
    public List<InstructorLec> getAll(int page, int size) {
        return null;
    }

    @Override
    public String delete(Long id) {
        try {
            return null;
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }

    }

    @Override
    public InstructorLec getById(Long id) {
        return null;
    }

    @Override
    public InstructorLec create(InstructorLec instructorLec) {
        try {
            return null;

        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }

    @Override
    public InstructorLec update(InstructorLec instructorLec) {
        try {
            return null;
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }

    }




}
