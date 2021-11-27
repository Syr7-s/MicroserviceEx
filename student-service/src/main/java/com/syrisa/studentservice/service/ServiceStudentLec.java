package com.syrisa.studentservice.service;

import com.syrisa.studentservice.entity.impl.Entity;

public interface ServiceStudentLec <T extends Entity,V extends Entity>{
    T create(V v);
}
