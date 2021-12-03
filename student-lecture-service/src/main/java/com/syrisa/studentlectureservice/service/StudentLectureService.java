package com.syrisa.studentlectureservice.service;


import com.syrisa.studentlectureservice.entity.impl.StudentLecture;

public interface StudentLectureService extends Service<StudentLecture>{
    StudentLecture findStudentLectureByStudentNumber(Long studentNumber);
}
