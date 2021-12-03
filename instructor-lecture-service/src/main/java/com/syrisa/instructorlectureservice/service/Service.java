package com.syrisa.instructorlectureservice.service;

import com.syrisa.instructorlectureservice.entity.Entity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface Service <T extends Entity> {
    T create(T t);
    T update(T t);
    Page<T> getAll(Pageable pageable);
}
