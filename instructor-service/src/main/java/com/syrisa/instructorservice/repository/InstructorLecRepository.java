package com.syrisa.instructorservice.repository;

import com.syrisa.instructorservice.entity.impl.InstructorLec;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorLecRepository extends MongoRepository<InstructorLec,Long> {
}
