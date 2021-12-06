package com.syrisa.instructorlectureservice.entity.impl;


import com.syrisa.instructorlectureservice.dto.InstructorLecDto;
import com.syrisa.instructorlectureservice.entity.Entity;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;


import java.time.LocalDate;

@Data
@Builder
@Document
public class InstructorLec implements Entity {
    @Id
    private Long instructorLecID;
    private String lectureCode;
    private String instructorID;
    private String instructorNameSurname;
    private int studentCapacity;
    private LocalDate openDate;

    public InstructorLecDto toInstructorLecDto(){
        return  InstructorLecDto.builder()
                .instructorLecID(this.instructorLecID)
                .lectureCode(this.lectureCode)
                .instructorID(this.instructorID)
                .instructorNameSurname(this.instructorNameSurname)
                .studentCapacity(this.studentCapacity)
                .openDate(this.openDate)
                .build();
    }
}
