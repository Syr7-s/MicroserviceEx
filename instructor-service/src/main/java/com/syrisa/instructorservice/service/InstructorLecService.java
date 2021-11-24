package com.syrisa.instructorservice.service;

import com.syrisa.instructorservice.entity.impl.InstructorLec;

public interface InstructorLecService extends Service<InstructorLec> {
    InstructorLec getByID(Long id);

    InstructorLec getByLectureCode(String lectureCode);

    String delete(Long id);
}
