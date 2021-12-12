package com.syrisa.instructorservice.service.impl;

import com.syrisa.instructorservice.client.GenerateProcessClient;
import com.syrisa.instructorservice.entity.impl.Address;
import com.syrisa.instructorservice.entity.impl.Instructor;
import com.syrisa.instructorservice.exception.InstructorNotNullException;
import com.syrisa.instructorservice.repository.AddressRepository;
import com.syrisa.instructorservice.repository.InstructorRepository;
import com.syrisa.instructorservice.service.InstructorService;
import io.vavr.collection.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepository;
    private final AddressRepository addressRepository;
    private final GenerateProcessClient generateProcessClient;

    @Override
    public Instructor create(Instructor instructor) {
        try {
            if (instructor != null) {
                Address address = instructor.getAddress();
                address.setAddressID(Long.parseLong(generateProcessClient.generateNumber(5)));
                addressRepository.save(address);
                instructor.setInstructorID(Long.parseLong(generateProcessClient.generateNumber(10)));
                return instructorRepository.save(instructor);
            }
            throw new InstructorNotNullException("Instructor not null exception");

        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }

    }

    @Override
    public Instructor update(Instructor instructor) {
        try {
            Instructor editedInstructor = getByID(instructor.getInstructorID());
            if (editedInstructor != null) {
                return instructorRepository.save(instructor);
            }
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, instructor.getInstructorName() + " " + instructor.getInstructorLastName() + " named instructor not was defined on the system");
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }

    @Override
    public Instructor getByID(Long id) {
        return instructorRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, id + " numbered instructor not found on the system"));
    }

    @Override
    public Page<Instructor> getAll(Pageable pageable) {
        return instructorRepository.findAll(pageable);
    }

    @Override
    public String delete(Long id) {
        try {
            Instructor instructor = getByID(id);
            instructorRepository.delete(instructor);
            return instructor.getInstructorName() + " " + instructor.getInstructorLastName() + " named instructor was deleted.";
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }
}
