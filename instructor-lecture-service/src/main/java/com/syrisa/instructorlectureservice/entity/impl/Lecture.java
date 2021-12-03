package com.syrisa.instructorlectureservice.entity.impl;


import com.syrisa.instructorlectureservice.entity.Entity;
import lombok.Data;

@Data
public class Lecture implements Entity {
    private Integer lectureID;
    private String lectureCode;
    private String lectureName;
    private Integer lectureCapacity;
}
