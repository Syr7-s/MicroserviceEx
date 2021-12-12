package com.syrisa.webappbff.dto;


import com.syrisa.webappbff.entity.InstructorLec;
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
    private String instructorID;
    private String instructorNameSurname;
    private int studentCapacity;
    private int studentCount;
    private LocalDate openDate;


    public InstructorLec toInstructorLec(){
        return  InstructorLec.builder()
                .instructorLecID(this.instructorLecID)
                .lectureCode(this.lectureCode)
                .instructorID(this.instructorID)
                .instructorNameSurname(this.instructorNameSurname)
                .studentCapacity(this.studentCapacity)
                .studentCount(this.studentCount)
                .openDate(this.openDate)
                .build();
    }
}
