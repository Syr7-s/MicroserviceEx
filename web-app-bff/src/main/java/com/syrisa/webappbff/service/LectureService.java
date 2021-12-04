package com.syrisa.webappbff.service;

import com.syrisa.webappbff.entity.Lecture;

import java.util.List;

public interface LectureService extends Service<Lecture,Integer>{
    List<Lecture> getAll(int min,int max);
    Lecture getLectureByLectureCode(String lectureCode);
}
