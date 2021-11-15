package com.syrisa.instructorservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorLecRepository extends MongoRepository<InstructorLecRepository,Long> {
}
