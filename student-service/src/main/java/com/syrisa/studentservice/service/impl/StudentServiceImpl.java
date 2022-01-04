package com.syrisa.studentservice.service.impl;

import com.syrisa.studentservice.client.GenerateProcessClient;
import com.syrisa.studentservice.entity.Address;
import com.syrisa.studentservice.entity.Student;
import com.syrisa.studentservice.exception.StudentNotNullException;
import com.syrisa.studentservice.mapper.repository.AddressRepository;
import com.syrisa.studentservice.mapper.repository.StudentRepository;
import com.syrisa.studentservice.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final AddressRepository addressRepository;
    private final GenerateProcessClient generateProcessClient;

    @Override
    public Student create(Student student) {
        try {
            if (student != null) {
                Address address = student.getAddress();
                address.setAddressID(Long.parseLong(generateProcessClient.generateNumber(5)));
                addressRepository.save(address);
                student.setStudentID(Long.parseLong(generateProcessClient.generateNumber(6)));
                Long number = Long.parseLong(String.valueOf(LocalDate.now().getYear()).substring(2) + Long.parseLong(generateProcessClient.generateNumber(10)));
                System.out.println("Number: "+number);
                student.setStudentNumber(number);
                return studentRepository.save(student);
            }
            throw new StudentNotNullException("Student not null");
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }

    }

    @Override
    public Student update(Student student) {
        try {
            if (student != null) {
                return studentRepository.save(student);
            }
            throw new StudentNotNullException("Student not null");
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }

    @Override
    public Student getByID(Long id) {
        try {
            return studentRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,id+" numbered student not found on the system"));
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        }
    }

    @Override
    public Page<Student> getAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public String delete(Long id) {
        try{
            Student student = getByID(id);
            Address address = addressRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Address not found"));
            addressRepository.delete(address);
            studentRepository.delete(student);
            return student.getStudentName()+" "+student.getStudentLastName()+ "named student was deleted.";
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        }
    }


    @Override
    public Student findStudentByStudentNumber(Long studentNumber) {
        return studentRepository.findStudentByStudentNumber(studentNumber).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Student not found"));
    }
}
