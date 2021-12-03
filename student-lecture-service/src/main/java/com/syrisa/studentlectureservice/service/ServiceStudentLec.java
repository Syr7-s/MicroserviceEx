package com.syrisa.studentlectureservice.service;

import com.syrisa.studentlectureservice.entity.Entity;


public interface ServiceStudentLec <T extends Entity,V extends Entity>{
    T create(V v);
}
