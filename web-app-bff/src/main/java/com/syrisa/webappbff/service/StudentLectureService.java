package com.syrisa.webappbff.service;

import com.syrisa.webappbff.entity.StudentLecture;

public interface StudentLectureService extends Service<StudentLecture, Long> {
    StudentLecture findStudentLectureByStudentNumber(Long studentNumber);
}
