package com.syrisa.studentlectureservice.entity.impl;

import com.syrisa.studentlectureservice.dto.InstructorLecDto;
import com.syrisa.studentlectureservice.entity.Entity;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class InstructorLec implements Entity {
    private Long instructorLecID;
    private String lectureCode;
    private String instructorID;
    private String instructorNameSurname;
    private int studentCapacity;
    private LocalDate openDate;
    public InstructorLecDto toInstructorLecDto(){
        return  InstructorLecDto.builder()
                .instructorLecID(this.instructorLecID)
                .lectureCode(this.lectureCode)
                .instructorID(this.instructorID)
                .instructorNameSurname(this.instructorNameSurname)
                .studentCapacity(this.studentCapacity)
                .openDate(this.openDate)
                .build();
    }
}
