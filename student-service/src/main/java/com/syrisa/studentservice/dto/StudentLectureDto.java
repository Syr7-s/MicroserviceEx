package com.syrisa.studentservice.dto;

import com.syrisa.studentservice.entity.InstructorLec;
import com.syrisa.studentservice.entity.StudentLecture;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class StudentLectureDto {
    private Long studentLecID;
    private LocalDate lastUpdated;
    private int status;
    private Long studentNumber;
    private String studentNameAndSurname;
    private List<InstructorLec> studentLectures;

    public StudentLecture toStudentLecture(){
        return StudentLecture.builder()
                .studentLecID(this.studentLecID)
                .lastUpdated(this.lastUpdated)
                .status(this.status)
                .studentNumber(this.studentNumber)
                .studentNameAndSurname(this.studentNameAndSurname)
                .studentLectures(this.studentLectures)
                .build();
    }

}
