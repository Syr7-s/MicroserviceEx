package com.syrisa.studentservice.dto;

import com.syrisa.instructorservice.entity.impl.InstructorLec;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
public class InstructorLecDto {
    private Long instructorLecID;
    private String lectureCode;
    private String instructorID;
    private String instructorNameSurname;
    private int studentCapacity;
    private LocalDate openDate;


}
