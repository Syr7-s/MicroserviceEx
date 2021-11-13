package com.syrisa.studentservice.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.syrisa.studentservice.utility.enums.Gender.Gender;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document
public class Student {
    private Long studentID;
    private String studentName;
    private String studentLastName;
    private Gender studentGender;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate accountCreationDate;
    private Address address;
}
