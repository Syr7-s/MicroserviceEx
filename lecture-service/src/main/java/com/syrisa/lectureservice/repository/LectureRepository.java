package com.syrisa.lectureservice.repository;

import com.syrisa.lectureservice.entity.Lecture;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureRepository extends MongoRepository<Lecture,Integer> {
}
