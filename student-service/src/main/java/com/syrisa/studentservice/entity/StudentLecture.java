package com.syrisa.studentservice.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Builder
@Document
public class StudentLecture implements Entity{
    @Id
    private Long studentLecID;
    private LocalDate lastUpdated;
    private int status;
    private String studentID;
    private String studentNameAndSurname;
    private String lectureCode;
    private String lectureName;
}
