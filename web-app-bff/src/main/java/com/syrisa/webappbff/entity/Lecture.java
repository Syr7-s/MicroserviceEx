package com.syrisa.webappbff.entity;


import com.syrisa.webappbff.dto.LectureDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Lecture implements Entity {

    private Integer lectureID;
    private String lectureCode;
    private String lectureName;


    public LectureDto toLectureDto() {
        return LectureDto.builder().
                lectureID(this.lectureID)
                .lectureCode(this.lectureCode)
                .lectureName(this.lectureName)
                .build();
    }
}
