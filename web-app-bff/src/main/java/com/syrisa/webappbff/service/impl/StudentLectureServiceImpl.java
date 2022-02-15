package com.syrisa.webappbff.service.impl;

import com.syrisa.webappbff.client.StudentLectureServiceClient;
import com.syrisa.webappbff.entity.Student;
import com.syrisa.webappbff.entity.StudentLecture;
import com.syrisa.webappbff.service.StudentLectureService;
import com.syrisa.webappbff.service.StudentService;
import com.syrisa.webappbff.utility.checkObject.ObjectContainerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class StudentLectureServiceImpl implements StudentLectureService {
    private final StudentLectureServiceClient studentLectureServiceClient;
    private final StudentService studentService;

    @Override
    public StudentLecture create(StudentLecture studentLecture) {
        Student student = studentService.findByStudentNumber(studentLecture.getStudentNumber());
        if (new ObjectContainerService<Student>().isNull.test(student)){
            return studentLectureServiceClient.create(studentLecture.toStudentLectureDto()).toStudentLecture();
        }
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Student not found");
    }

    @Override
    public StudentLecture update(StudentLecture studentLecture) {
        Student student = studentService.findByStudentNumber(studentLecture.getStudentNumber());
        if (new ObjectContainerService<Student>().isNull.test(student)){
            return studentLectureServiceClient.update(studentLecture.toStudentLectureDto()).toStudentLecture();
        }
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Student not found");
    }

    @Override
    public String delete(Long id) {
        return studentLectureServiceClient.delete(id);
    }

    @Override
    public StudentLecture getById(Long id) {
        return studentLectureServiceClient.getById(id).toStudentLecture();
    }

    @Override
    public StudentLecture findStudentLectureByStudentNumber(Long studentNumber) {
        return studentLectureServiceClient.findStudentLectureByStudentNumber(studentNumber).toStudentLecture();
    }
}
