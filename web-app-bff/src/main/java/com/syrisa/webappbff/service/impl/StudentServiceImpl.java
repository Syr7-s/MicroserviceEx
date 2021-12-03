package com.syrisa.webappbff.service.impl;

import com.syrisa.webappbff.client.StudentServiceClient;
import com.syrisa.webappbff.entity.Student;
import com.syrisa.webappbff.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentServiceClient studentServiceClient;

    public StudentServiceImpl(StudentServiceClient studentServiceClient) {
        this.studentServiceClient = studentServiceClient;
    }

    @Override
    public Student create(Student student) {
        try{
            return studentServiceClient.create(student.toStudentDto()).toStudent();
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        }

    }

    @Override
    public Student update(Student student) {
        try{
            return studentServiceClient.update(student.toStudentDto()).toStudent();
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        }
    }

    @Override
    public String delete(Long id) {
        try{
            return studentServiceClient.delete(id);
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        }
    }

    @Override
    public Student getById(Long id) {
        try{
            return studentServiceClient.getByID(id);
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        }
    }


    @Override
    public Student findByStudentNumber(Long studentNumber) {
        try{
            return studentServiceClient.getByStudentNumber(studentNumber).toStudent();
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        }
    }
}
