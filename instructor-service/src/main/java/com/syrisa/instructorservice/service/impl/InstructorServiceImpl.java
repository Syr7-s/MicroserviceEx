package com.syrisa.instructorservice.service.impl;

import com.syrisa.instructorservice.client.GenerateProcessClient;
import com.syrisa.instructorservice.entity.impl.Address;
import com.syrisa.instructorservice.entity.impl.Instructor;
import com.syrisa.instructorservice.exception.InstructorNotNullException;
import com.syrisa.instructorservice.repository.AddressRepository;
import com.syrisa.instructorservice.repository.InstructorRepository;
import com.syrisa.instructorservice.service.InstructorService;
import io.vavr.collection.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepository;
    private final AddressRepository addressRepository;
    private final GenerateProcessClient generateProcessClient;
    public InstructorServiceImpl(InstructorRepository instructorRepository, AddressRepository addressRepository, GenerateProcessClient generateProcessClient) {
        this.instructorRepository = instructorRepository;
        this.addressRepository = addressRepository;
        this.generateProcessClient = generateProcessClient;
    }

    @Override
    public Instructor create(Instructor instructor) {
        try {
            if (instructor!=null){
                Address address = instructor.getAddress();
                address.setAddressID(Long.parseLong(generateProcessClient.generateNumber(5)));
                addressRepository.save(address);
                instructor.setInstructorID(Long.parseLong(generateProcessClient.generateNumber(10)));
                return instructorRepository.save(instructor);
            }
            throw new InstructorNotNullException("Instructor not null exception");

        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        }

    }

    @Override
    public Instructor update(Instructor instructor) {
        return null;
    }

    @Override
    public Instructor getByID(Long id) {
        return null;
    }

    @Override
    public List<Instructor> getAll() {
        return null;
    }

    @Override
    public String delete(Long id) {
        return null;
    }
}
