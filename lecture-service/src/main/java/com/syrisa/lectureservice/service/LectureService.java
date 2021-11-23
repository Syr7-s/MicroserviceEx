package com.syrisa.lectureservice.service;

import io.vavr.collection.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LectureService <T>{
    T create(T t);
    T update(T t);
    T getByID(Long id);
    Page<T> getAll(Pageable pageable);
    String delete(Long id);
    T getLectureByLectureCode(String lectureCode);
}
