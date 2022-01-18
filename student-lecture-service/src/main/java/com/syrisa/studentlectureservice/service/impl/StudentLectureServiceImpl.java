package com.syrisa.studentlectureservice.service.impl;

import com.syrisa.studentlectureservice.checkobject.PreCondition;
import com.syrisa.studentlectureservice.client.InstructorLecServiceClient;
import com.syrisa.studentlectureservice.entity.impl.InstructorLec;
import com.syrisa.studentlectureservice.entity.impl.StudentLecture;
import com.syrisa.studentlectureservice.repository.StudentLectureRepository;
import com.syrisa.studentlectureservice.service.StudentLectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class StudentLectureServiceImpl implements StudentLectureService {
    private final StudentLectureRepository studentLectureRepository;
    private final InstructorLecServiceClient instructorLecServiceClient;

    @Override
    public StudentLecture create(StudentLecture studentLecture) {
        try {
            PreCondition.checkNull(studentLecture);
            StudentLecture student = findStudentLectureByStudentNumber(studentLecture.getStudentNumber());
            List<InstructorLec> instructorLectures = studentLecture.getStudentLectures();
            instructorLectures = addStudentsInfo.apply(instructorLectures);
            if (student == null) {
                student = new StudentLecture();
                student = fillStudentLecture.apply(student, studentLecture).apply(instructorLectures);
            } else {
                List<InstructorLec> instructorLecList = student.getStudentLectures();
                instructorLecList.addAll(instructorLectures);
                student.setStudentLectures(instructorLecList);
            }
            return studentLectureRepository.save(student);
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }

    @Override
    public StudentLecture update(StudentLecture studentLecture) {
        try{
            throw new Exception("Update process not ready yet");
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        }
    }

    @Override
    public StudentLecture getByID(Long id) {
        return studentLectureRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"));
    }

    @Override
    public Page<StudentLecture> getAll(Pageable pageable) {
        return studentLectureRepository.findAll(pageable);
    }

    @Override
    public String delete(Long id) {
        return "Not ready yet";
    }

    @Override
    public StudentLecture findStudentLectureByStudentNumber(Long studentNumber) {
        return studentLectureRepository.findStudentLectureByStudentNumber(studentNumber);
    }

    Function<List<InstructorLec>, List<InstructorLec>> addStudentsInfo = (instructorLecs -> {
        PreCondition.checkNull(instructorLecs);
        List<InstructorLec> registeredInstructorList = new ArrayList<>();
        for (InstructorLec instructorLec : instructorLecs) {
            InstructorLec instructorLecture = instructorLecServiceClient.addStudent(instructorLec.getInstructorLecID()).toInstructorLec();
            registeredInstructorList.add(instructorLecture);
        }
        return registeredInstructorList;
    });
    BiFunction<StudentLecture, StudentLecture, Function<List<InstructorLec>, StudentLecture>> fillStudentLecture = (studentLec, studentEdit) -> (instructorLecs -> {
        studentLec.setStudentLecID(studentEdit.getStudentLecID());
        studentLec.setLastUpdated(studentEdit.getLastUpdated());
        studentLec.setStatus(studentEdit.getStatus());
        studentLec.setStudentNumber(studentEdit.getStudentNumber());
        studentLec.setStudentNameAndSurname(studentEdit.getStudentNameAndSurname());
        studentLec.setStudentLectures(instructorLecs);
        return studentLec;
    });
}
