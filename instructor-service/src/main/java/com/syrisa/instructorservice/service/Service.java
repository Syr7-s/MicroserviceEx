package com.syrisa.instructorservice.service;

import com.syrisa.instructorservice.entity.Entity;
import io.vavr.collection.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface Service <T extends Entity> {
    T create(T t);
    T update(T t);
    Page<T> getAll(Pageable pageable);
}
