package com.syrisa.studentservice.service.impl;

import com.syrisa.studentservice.client.InstructorLecProcessClient;
import com.syrisa.studentservice.entity.Student;
import com.syrisa.studentservice.entity.StudentLecture;
import com.syrisa.studentservice.entity.StudentLectureInfo;
import com.syrisa.studentservice.repository.StudentLectureRepository;
import com.syrisa.studentservice.service.StudentLectureInfoService;
import com.syrisa.studentservice.service.StudentLectureService;
import com.syrisa.studentservice.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class StudentLectureServiceImpl implements StudentLectureService {
    private final StudentLectureRepository studentLectureRepository;
    private final StudentLectureInfoService studentLectureInfoService;
    private final StudentService studentService;
    private final InstructorLecProcessClient instructorLecProcessClient;

    public StudentLectureServiceImpl(StudentLectureRepository studentLectureRepository, StudentLectureInfoService studentLectureInfoService, StudentService studentService, InstructorLecProcessClient instructorLecProcessClient) {
        this.studentLectureRepository = studentLectureRepository;
        this.studentLectureInfoService = studentLectureInfoService;
        this.studentService = studentService;
        this.instructorLecProcessClient = instructorLecProcessClient;
    }


    @Override
    public StudentLecture create(StudentLecture studentLecture) {
        return null;
    }

    @Override
    public StudentLecture update(StudentLecture studentLecture) {
        return null;
    }

    @Override
    public StudentLecture getByID(Long id) {
        return null;
    }

    @Override
    public Page<StudentLecture> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public String delete(Long id) {
        return null;
    }
}
