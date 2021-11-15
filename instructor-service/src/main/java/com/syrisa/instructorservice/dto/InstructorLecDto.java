package com.syrisa.instructorservice.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
@Builder
public class InstructorLecDto {
    @Id
    private Long instructorLecID;
    private String lectureCode;
    private String instructorID;
    private String instructorNameSurname;
    private int studentCapacity;
    private LocalDate openDate;
}
