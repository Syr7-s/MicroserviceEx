package com.syrisa.studentservice.service;

import com.syrisa.studentservice.entity.Student;

public interface StudentService  extends Service<Student>{
    Student findStudentByStudentNumber(Long studentNumber);
}
