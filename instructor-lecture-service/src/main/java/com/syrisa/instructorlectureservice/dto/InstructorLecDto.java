package com.syrisa.instructorlectureservice.dto;


import com.syrisa.instructorlectureservice.entity.impl.InstructorLec;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
@Builder
public class InstructorLecDto {
    @Id
    private Long instructorLecID;
    private String lectureCode;
    private Long instructorID;
    private String instructorNameSurname;
    private int studentCapacity;
    private LocalDate openDate;


    public InstructorLec toInstructorLec(){
        return  InstructorLec.builder()
                .instructorLecID(this.instructorLecID)
                .lectureCode(this.lectureCode)
                .instructorID(this.instructorID)
                .instructorNameSurname(this.instructorNameSurname)
                .studentCapacity(this.studentCapacity)
                .openDate(this.openDate)
                .build();
    }
}
