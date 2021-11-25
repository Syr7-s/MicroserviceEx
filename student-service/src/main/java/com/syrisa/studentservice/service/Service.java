package com.syrisa.studentservice.service;

import com.syrisa.studentservice.entity.impl.Entity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface Service<T extends Entity> {
    T create(T t);
    T update(T t);
    T getByID(Long id);
    Page<T> getAll(Pageable pageable);
    String delete(Long id);
}
