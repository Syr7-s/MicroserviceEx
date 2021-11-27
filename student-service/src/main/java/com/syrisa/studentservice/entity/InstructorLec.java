package com.syrisa.studentservice.entity;

import com.syrisa.studentservice.entity.impl.Entity;
import lombok.Data;

import java.time.LocalDate;

@Data
public class InstructorLec implements Entity {
    private Long instructorLecID;
    private String lectureCode;
    private String instructorID;
    private String instructorNameSurname;
    private int studentCapacity;
    private LocalDate openDate;

}
