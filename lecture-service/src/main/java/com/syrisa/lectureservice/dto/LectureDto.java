package com.syrisa.lectureservice.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class LectureDto {
    private Long lectureID;
    private String lectureCode;
    private String lectureName;
    private String lectureInstructorID;
    private int lectureStudentCount;
    private Set<Long> studentID;
}
