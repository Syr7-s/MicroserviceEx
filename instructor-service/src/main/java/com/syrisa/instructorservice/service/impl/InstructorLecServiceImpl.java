package com.syrisa.instructorservice.service.impl;

import com.syrisa.instructorservice.entity.impl.InstructorLec;
import com.syrisa.instructorservice.service.InstructorLecService;
import io.vavr.collection.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InstructorLecServiceImpl implements InstructorLecService {
    @Override
    public InstructorLec getByID(Long id) {
        return null;
    }

    @Override
    public String delete(Long id) {
        return null;
    }

    @Override
    public InstructorLec create(InstructorLec instructorLec) {
        return null;
    }

    @Override
    public InstructorLec update(InstructorLec instructorLec) {
        return null;
    }

    @Override
    public List<InstructorLec> getAll() {
        return null;
    }
}
