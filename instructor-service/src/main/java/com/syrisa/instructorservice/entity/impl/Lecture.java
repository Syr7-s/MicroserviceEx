package com.syrisa.instructorservice.entity.impl;

import com.syrisa.instructorservice.entity.Entity;
import lombok.Data;

@Data
public class Lecture implements Entity {
    private Integer lectureID;
    private String lectureCode;
    private String lectureName;
    private Integer lectureCapacity;
}
