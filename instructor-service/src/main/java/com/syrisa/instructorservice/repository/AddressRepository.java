package com.syrisa.instructorservice.repository;

import com.syrisa.instructorservice.entity.Instructor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends MongoRepository<Instructor,Long> {
}
