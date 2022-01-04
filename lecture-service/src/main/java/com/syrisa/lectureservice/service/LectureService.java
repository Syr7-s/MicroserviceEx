package com.syrisa.lectureservice.service;

import io.vavr.collection.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LectureService <T>{
    T create(T t);
    T update(T t);
    T getByID(Integer id);
    Page<T> getAll(Pageable pageable);
    String delete(Integer id);
    T getLectureByLectureCode(String lectureCode);
}
