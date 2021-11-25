package com.syrisa.studentservice.entity;

import com.syrisa.studentservice.dto.StudentLectureDto;
import com.syrisa.studentservice.entity.impl.Entity;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Builder
@Document
public class StudentLecture implements Entity {
    @Id
    private Long studentLecID;
    private LocalDate lastUpdated;
    private int status;
    private Long studentNumber;
    private String studentNameAndSurname;
    private String lectureCode;
    private String lectureName;

    public StudentLectureDto toStudentLectureDto(){
        return StudentLectureDto.builder()
                .studentLecID(this.studentLecID)
                .lastUpdated(this.lastUpdated)
                .status(this.status)
                .studentNumber(this.studentNumber)
                .studentNameAndSurname(this.studentNameAndSurname)
                .lectureCode(this.lectureCode)
                .lectureName(this.lectureName)
                .build();
    }
}
