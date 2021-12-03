package com.syrisa.studentlectureservice.repository;


import com.syrisa.studentlectureservice.entity.impl.StudentLectureInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentLectureInfoRepository extends MongoRepository<StudentLectureInfo,Long> {
}
