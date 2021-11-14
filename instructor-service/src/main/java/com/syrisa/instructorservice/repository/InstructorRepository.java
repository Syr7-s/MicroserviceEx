package com.syrisa.instructorservice.repository;

import com.mongodb.client.MongoDatabase;
import com.syrisa.instructorservice.entity.Instructor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends MongoRepository<Instructor,Long> {
}
