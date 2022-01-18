package com.syrisa.webappbff.service.impl;

import com.syrisa.webappbff.client.StudentLectureServiceClient;
import com.syrisa.webappbff.entity.Student;
import com.syrisa.webappbff.entity.StudentLecture;
import com.syrisa.webappbff.service.StudentLectureService;
import com.syrisa.webappbff.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentLectureServiceImpl implements StudentLectureService {
    private final StudentLectureServiceClient studentLectureServiceClient;
    private final StudentService studentService;

    @Override
    public StudentLecture create(StudentLecture studentLecture) {
        Student student = studentService.findByStudentNumber(studentLecture.getStudentNumber());

        return null;
    }

    @Override
    public StudentLecture update(StudentLecture studentLecture) {
        return null;
    }

    @Override
    public String delete(Long id) {
        return null;
    }

    @Override
    public StudentLecture getById(Long id) {
        return null;
    }

    @Override
    public StudentLecture findStudentLectureByStudentNumber(Long studentNumber) {
        return null;
    }
}
