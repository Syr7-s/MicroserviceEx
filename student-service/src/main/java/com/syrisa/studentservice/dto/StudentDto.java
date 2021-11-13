package com.syrisa.studentservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.syrisa.studentservice.entity.Address;
import com.syrisa.studentservice.utility.enums.Gender.Gender;
import lombok.Data;

import java.time.LocalDate;
@Data
public class StudentDto {
    private Long studentID;
    private String studentName;
    private String studentLastName;
    private Gender studentGender;
    private LocalDate studentBirthDate;
    private Address address;
}
