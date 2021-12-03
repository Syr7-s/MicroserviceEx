package com.syrisa.studentlectureservice.service.impl;

import com.syrisa.studentlectureservice.entity.impl.StudentLecture;
import com.syrisa.studentlectureservice.repository.StudentLectureRepository;
import com.syrisa.studentlectureservice.service.StudentLectureInfoService;
import com.syrisa.studentlectureservice.service.StudentLectureService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional(rollbackFor = Exception.class)
public class StudentLectureServiceImpl implements StudentLectureService {
    private final StudentLectureRepository studentLectureRepository;
    private final StudentLectureInfoService studentLectureInfoService;

    public StudentLectureServiceImpl(StudentLectureRepository studentLectureRepository, StudentLectureInfoService studentLectureInfoService) {
        this.studentLectureRepository = studentLectureRepository;
        this.studentLectureInfoService = studentLectureInfoService;
    }


    @Override
    public StudentLecture create(StudentLecture studentLecture) {
        try{

        }catch (Exception exception){

        }
        return null;
    }

    @Override
    public StudentLecture update(StudentLecture studentLecture) {
        return null;
    }

    @Override
    public StudentLecture getByID(Long id) {
        return studentLectureRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Not Found"));
    }

    @Override
    public Page<StudentLecture> getAll(Pageable pageable) {
        return studentLectureRepository.findAll(pageable);
    }

    @Override
    public String delete(Long id) {
        return null;
    }

    @Override
    public StudentLecture findStudentLectureByStudentNumber(Long studentNumber) {
        return studentLectureRepository.findStudentLectureByStudentNumber(studentNumber);
    }
}
