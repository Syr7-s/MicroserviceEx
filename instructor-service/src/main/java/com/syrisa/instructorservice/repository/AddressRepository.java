package com.syrisa.instructorservice.repository;

import com.syrisa.instructorservice.entity.impl.Address;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends MongoRepository<Address,Long> {
}
