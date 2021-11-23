package com.syrisa.lectureservice.service;

import io.vavr.collection.List;

public interface LectureService <T>{
    T create(T t);
    T update(T t);
    T getByID(Long id);
    List<T> getAll();
    String delete(Long id);
    T getLectureByLectureCode(String lectureCode);
}
