package com.syrisa.lectureservice.entity;

import com.syrisa.lectureservice.dto.LectureDto;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@Builder
@Document
public class Lecture {
    @Id
    private Integer lectureID;
    private String lectureCode;
    private String lectureName;


    public LectureDto toLectureDto(){
        return LectureDto.builder().
                lectureID(this.lectureID)
                .lectureCode(this.lectureCode)
                .lectureName(this.lectureName)
                .build();
    }
}
