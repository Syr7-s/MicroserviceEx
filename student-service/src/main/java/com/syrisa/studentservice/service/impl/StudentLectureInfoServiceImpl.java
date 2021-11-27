package com.syrisa.studentservice.service.impl;

import com.syrisa.studentservice.client.GenerateProcessClient;
import com.syrisa.studentservice.client.InstructorLecProcessClient;
import com.syrisa.studentservice.entity.InstructorLec;
import com.syrisa.studentservice.entity.Student;
import com.syrisa.studentservice.entity.StudentLecture;
import com.syrisa.studentservice.entity.StudentLectureInfo;
import com.syrisa.studentservice.exception.StudentExceedLectureBoundsException;
import com.syrisa.studentservice.repository.StudentLectureRepository;
import com.syrisa.studentservice.service.StudentLectureInfoService;
import com.syrisa.studentservice.service.StudentLectureService;
import com.syrisa.studentservice.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
@Transactional(rollbackFor = Exception.class)
public class StudentLectureInfoServiceImpl implements StudentLectureInfoService {
    private final StudentService studentService;
    private final InstructorLecProcessClient instructorLecProcessClient;
    private final StudentLectureService studentLectureService;
    private final GenerateProcessClient generateProcessClient;
    private final StudentLectureRepository studentLectureRepository;


    public StudentLectureInfoServiceImpl(StudentService studentService, InstructorLecProcessClient instructorLecProcessClient, StudentLectureService studentLectureService, GenerateProcessClient generateProcessClient, StudentLectureRepository studentLectureRepository) {
        this.studentService = studentService;
        this.instructorLecProcessClient = instructorLecProcessClient;
        this.studentLectureService = studentLectureService;
        this.generateProcessClient = generateProcessClient;
        this.studentLectureRepository = studentLectureRepository;
    }

    @Override
    public StudentLecture create(StudentLectureInfo studentLectureInfo) {
        try {
            StudentLecture studentLecture = studentLectureService.findStudentLectureByStudentNumber(studentLectureInfo.getStudentNumber());
            List<InstructorLec> instructorLectures = null;
            InstructorLec instructorLec = null;
            if (studentLecture == null) {
                instructorLectures = new ArrayList<>();
                Student student = studentService.getByID(studentLectureInfo.getStudentNumber());
                instructorLec = instructorLecProcessClient.getById(studentLectureInfo.getStudentLectureCode()).toInstructorLec();
                studentLecture.setStudentLecID(Long.valueOf(generateProcessClient.generateNumber(6)));
                studentLecture.setLastUpdated(LocalDate.now());
                studentLecture.setStudentNumber(student.getStudentNumber());
                studentLecture.setStudentNameAndSurname(student.getStudentName() + " " + student.getStudentLastName());
                instructorLectures.add(instructorLec);
                studentLecture.setStudentLectures(instructorLectures);
            } else {
                instructorLec = instructorLecProcessClient.getById(studentLectureInfo.getStudentLectureCode()).toInstructorLec();
                instructorLectures = studentLecture.getStudentLectures();
                if (isStudentLectureCountLessThan.test(instructorLectures)) {
                    instructorLectures.add(instructorLec);
                    studentLecture.setStudentLectures(instructorLectures);
                } else {
                    throw new StudentExceedLectureBoundsException("The student can choose a maximum of 2 courses.");
                }
            }
            return studentLectureRepository.save(studentLecture);
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }

    private final Predicate<List<InstructorLec>> isStudentLectureCountLessThan = (instructorLectures -> instructorLectures.size() < 2);

}
