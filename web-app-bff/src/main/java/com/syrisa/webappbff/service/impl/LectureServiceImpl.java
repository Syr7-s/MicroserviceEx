package com.syrisa.webappbff.service.impl;


import com.syrisa.webappbff.client.LectureServiceClient;
import com.syrisa.webappbff.dto.LectureDto;
import com.syrisa.webappbff.entity.Lecture;
import com.syrisa.webappbff.service.LectureService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LectureServiceImpl implements LectureService {

    private final LectureServiceClient lectureServiceClient;

    @Override
    public Lecture create(Lecture lecture) {
        try {
            return lectureServiceClient.create(lecture.toLectureDto()).toLecture();
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }

    }

    @Override
    public Lecture update(Lecture lecture) {
        try {
            return lectureServiceClient.update(lecture.toLectureDto()).toLecture();
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }

    @Override
    public String delete(Integer id) {
        try {
            return lectureServiceClient.delete(id);
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }

    @Override
    public Lecture getById(Integer id) {
        try {
            return lectureServiceClient.getByID(id).toLecture();
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }


    @Override
    public List<Lecture> getAll(int min, int max) {
        return lectureServiceClient.getAllLecture(min, max).stream()
                .map(LectureDto::toLecture)
                .collect(Collectors.toList());
    }


    @Override
    public Lecture getLectureByLectureCode(String lectureCode) {
        try {
            return lectureServiceClient.getLectureByLectureCode(lectureCode).toLecture();
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage());
        }
    }
}
