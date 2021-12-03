package com.syrisa.instructorlectureservice.service;

import com.syrisa.instructorlectureservice.entity.impl.InstructorLec;


public interface InstructorLecService extends Service<InstructorLec> {
    InstructorLec getByID(Long id);

    InstructorLec getByLectureCode(String lectureCode);

    String delete(Long id);
}
