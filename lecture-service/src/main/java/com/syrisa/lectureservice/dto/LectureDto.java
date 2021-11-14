package com.syrisa.lectureservice.dto;

import com.syrisa.lectureservice.entity.Lecture;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class LectureDto {
    private Integer lectureID;
    private String lectureCode;
    private String lectureName;
    public Lecture toLecture(){
        return Lecture.builder().
                lectureID(this.lectureID)
                .lectureCode(this.lectureCode)
                .lectureName(this.lectureName)
                .build();
    }
}
