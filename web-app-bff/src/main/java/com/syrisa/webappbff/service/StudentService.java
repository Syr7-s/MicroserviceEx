package com.syrisa.webappbff.service;

import com.syrisa.webappbff.entity.Student;

public interface StudentService extends Service<Student>{
    Student findByStudentNumber(Long studentNumber);
}
