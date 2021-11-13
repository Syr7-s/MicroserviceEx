package com.syrisa.studentservice.repository;

import com.syrisa.studentservice.entity.Address;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends MongoRepository<Address,Long> {
}
