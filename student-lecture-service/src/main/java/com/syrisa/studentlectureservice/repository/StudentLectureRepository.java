package com.syrisa.studentlectureservice.repository;

import com.syrisa.studentlectureservice.entity.impl.StudentLecture;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentLectureRepository extends MongoRepository<StudentLecture,Long> {
    StudentLecture findStudentLectureByStudentNumber(Long studentNumber);

}
