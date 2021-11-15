package com.syrisa.instructorservice.service;

import com.syrisa.instructorservice.entity.Entity;
import io.vavr.collection.List;

public interface Service <T extends Entity> {
    T create(T t);
    T update(T t);
    List<T> getAll();
}
