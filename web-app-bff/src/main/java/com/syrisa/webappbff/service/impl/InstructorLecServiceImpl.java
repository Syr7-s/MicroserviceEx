package com.syrisa.webappbff.service.impl;

import com.syrisa.webappbff.client.InstructorLecServiceClient;
import com.syrisa.webappbff.dto.InstructorLecDto;
import com.syrisa.webappbff.entity.Entity;
import com.syrisa.webappbff.entity.Instructor;
import com.syrisa.webappbff.entity.InstructorLec;
import com.syrisa.webappbff.entity.Lecture;
import com.syrisa.webappbff.service.InstructorLecService;
import com.syrisa.webappbff.service.InstructorService;
import com.syrisa.webappbff.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InstructorLecServiceImpl implements InstructorLecService {

    private final InstructorLecServiceClient instructorLecServiceClient;
    private final LectureService lectureService;
    private final InstructorService instructorService;
    

    @Override
    public InstructorLec getByLectureCode(String lectureCode) {
        try{
            return instructorLecServiceClient.getLectureCode(lectureCode).toInstructorLec();
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }

    @Override
    public List<InstructorLec> getAll(int page, int size) {
        return instructorLecServiceClient.getAll(page, size).stream().map(InstructorLecDto::toInstructorLec).collect(Collectors.toList());
    }

    @Override
    public String delete(Long id) {
        try {
            return instructorLecServiceClient.delete(id);
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }

    }

    @Override
    public InstructorLec getById(Long id) {
        try{
            return instructorLecServiceClient.getByID(id).toInstructorLec();
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }

    @Override
    public InstructorLec create(InstructorLec instructorLec) {
        try {
            Lecture lecture = lectureService.getLectureByLectureCode(instructorLec.getLectureCode());
            Instructor instructor = instructorService.getById(instructorLec.getInstructorID());
            if (isNull.test(lecture) && isNull.test(instructor)){
                return instructorLecServiceClient.create(instructorLec.toInstructorLecDto()).toInstructorLec();
            }
            throw new Exception("Lecture or Instructor is null");
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

    private static final Predicate<Entity> isNull = (Objects::nonNull);


}
