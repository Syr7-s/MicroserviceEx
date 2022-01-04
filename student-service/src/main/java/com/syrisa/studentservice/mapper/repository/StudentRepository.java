package com.syrisa.studentservice.mapper.repository;

import com.syrisa.studentservice.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends MongoRepository<Student,Long> {
    Optional<Student> findStudentByStudentNumber(Long studentNumber);
}
