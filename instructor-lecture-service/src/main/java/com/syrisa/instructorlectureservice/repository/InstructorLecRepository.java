package com.syrisa.instructorlectureservice.repository;

import com.syrisa.instructorlectureservice.entity.impl.InstructorLec;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstructorLecRepository extends MongoRepository<InstructorLec,Long> {
    Optional<InstructorLec> findByLectureCode(String lectureCode);
}
