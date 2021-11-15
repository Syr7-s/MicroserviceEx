package com.syrisa.instructorservice.service;

import com.syrisa.instructorservice.entity.impl.Instructor;

public interface InstructorService extends Service<Instructor>{
    Instructor getByID(Long id);
    String delete(Long id);
}
