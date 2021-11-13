package com.syrisa.studentservice.service.impl;

import com.syrisa.studentservice.entity.Address;
import com.syrisa.studentservice.entity.Student;
import com.syrisa.studentservice.exception.StudentNotNullException;
import com.syrisa.studentservice.repository.AddressRepository;
import com.syrisa.studentservice.repository.StudentRepository;
import com.syrisa.studentservice.service.StudentService;
import io.vavr.collection.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class StudentServiceImpl implements StudentService<Student> {
    private final StudentRepository studentRepository;
    private final AddressRepository addressRepository;

    public StudentServiceImpl(StudentRepository studentRepository, AddressRepository addressRepository) {
        this.studentRepository = studentRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public Student create(Student student) {
        try{
            if (student!=null){
                Address address = student.getAddress();
                addressRepository.save(address);
                return studentRepository.save(student);
            }
            throw new StudentNotNullException("Exception");
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        }

    }

    @Override
    public Student upadte(Student student) {
        return null;
    }

    @Override
    public Student getByID(Long id) {
        return null;
    }

    @Override
    public List<Student> getAll() {
        return null;
    }

    @Override
    public String delete(Long id) {
        return null;
    }
}
