package com.syrisa.webappbff.dto;


import com.syrisa.webappbff.entity.Lecture;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LectureDto {
    private Integer lectureID;
    private String lectureCode;
    private String lectureName;

    public Lecture toLecture() {
        return Lecture.builder().
                lectureID(this.lectureID)
                .lectureCode(this.lectureCode)
                .lectureName(this.lectureName)
                .build();
    }
}
