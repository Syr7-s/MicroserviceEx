package com.syrisa.studentservice.repository;

import com.syrisa.studentservice.entity.StudentLecture;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentLectureRepository extends MongoRepository<StudentLecture,Long> {
    StudentLecture findStudentLectureByStudentNumber(Long studentNumber);
}
