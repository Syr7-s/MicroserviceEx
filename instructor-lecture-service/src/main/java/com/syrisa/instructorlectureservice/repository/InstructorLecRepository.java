package com.syrisa.instructorlectureservice.repository;

import com.syrisa.instructorlectureservice.entity.impl.InstructorLec;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstructorLecRepository extends CouchbaseRepository<InstructorLec,Long> {
    Optional<InstructorLec> findByLectureCode(String lectureCode);
}
