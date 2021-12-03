package com.syrisa.studentlectureservice.dto;



import com.syrisa.studentlectureservice.entity.impl.InstructorLec;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class InstructorLecDto {
    private Long instructorLecID;
    private String lectureCode;
    private String instructorID;
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
