package com.syrisa.webappbff.service;

import com.syrisa.webappbff.entity.Instructor;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface InstructorService extends Service<Instructor, Long> {
    List<Instructor> getAll(Pageable pageable);
}
