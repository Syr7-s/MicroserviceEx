package com.syrisa.instructorservice.service.impl;

import com.syrisa.instructorservice.entity.Instructor;
import com.syrisa.instructorservice.repository.AddressRepository;
import com.syrisa.instructorservice.repository.InstructorRepository;
import com.syrisa.instructorservice.service.InstructorService;
import io.vavr.collection.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InstructorServiceImpl implements InstructorService<Instructor> {
    private final InstructorRepository instructorRepository;
    private final AddressRepository addressRepository;
    public InstructorServiceImpl(InstructorRepository instructorRepository, AddressRepository addressRepository) {
        this.instructorRepository = instructorRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public Instructor create(Instructor instructor) {
        return null;
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
