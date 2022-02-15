package com.syrisa.webappbff.service;

import com.syrisa.webappbff.entity.InstructorLec;

import java.util.List;

public interface InstructorLecService extends Service<InstructorLec, Long> {
    InstructorLec getByLectureCode(String lectureCode);

    List<InstructorLec> getAll(int page, int size);
}
