package com.syrisa.instructorservice.service;

import io.vavr.collection.List;

public interface InstructorService <T>{
    T create(T t);
    T update(T t);
    T getByID(Long id);
    List<T> getAll();
    String delete(Long id);
}
