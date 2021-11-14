package com.syrisa.lectureservice.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@Builder
@Document
public class Lecture {
    private Long lectureID;
    private String lectureCode;
    private String lectureName;
    private String lectureInstructorID;
    private int lectureStudentCount;
    private Set<Long> studentID;

}
