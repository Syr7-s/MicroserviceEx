package com.syrisa.studentservice.service;

import io.vavr.collection.List;

public interface StudentService <T>{
    T create(T t);
    T upadte(T t);
    T getByID(Long id);
    List<T> getlAll();
    String delete(Long id);
}
