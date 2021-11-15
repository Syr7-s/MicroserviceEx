package com.syrisa.instructorservice.repository;

import com.syrisa.instructorservice.entity.impl.Instructor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends MongoRepository<Instructor,Long> {
}
