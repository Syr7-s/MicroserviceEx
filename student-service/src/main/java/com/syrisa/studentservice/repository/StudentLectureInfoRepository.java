package com.syrisa.studentservice.repository;

import com.syrisa.studentservice.entity.StudentLectureInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentLectureInfoRepository extends MongoRepository<StudentLectureInfo,Long> {
}
