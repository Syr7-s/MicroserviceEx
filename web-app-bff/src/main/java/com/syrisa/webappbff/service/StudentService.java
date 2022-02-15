package com.syrisa.webappbff.service;

import com.syrisa.webappbff.entity.Student;

public interface StudentService extends Service<Student, Long> {
    Student findByStudentNumber(Long studentNumber);
}
