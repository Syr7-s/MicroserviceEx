package com.syrisa.studentservice.dto;

import com.syrisa.studentservice.entity.StudentLecture;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class StudentLectureDto {
    private Long studentLecID;
    private LocalDate lastUpdated;
    private int status;
    private String studentID;
    private String studentNameAndSurname;
    private String lectureCode;
    private String lectureName;

    public StudentLecture toStudentLecture(){
        return StudentLecture.builder()
                .studentLecID(this.studentLecID)
                .lastUpdated(this.lastUpdated)
                .status(this.status)
                .studentID(this.studentID)
                .studentNameAndSurname(this.studentNameAndSurname)
                .lectureCode(this.lectureCode)
                .lectureName(this.lectureName)
                .build();
    }

}