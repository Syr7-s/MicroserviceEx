package com.syrisa.webappbff.entity;

import com.syrisa.webappbff.dto.InstructorLecDto;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
@Builder
public class InstructorLec implements Entity {
    @Id
    private Long instructorLecID;
    private String lectureCode;
    private Long instructorID;
    private String instructorNameSurname;
    private int studentCapacity;
    private int studentCount;
    private LocalDate openDate;

    public InstructorLecDto toInstructorLecDto(){
        return  InstructorLecDto.builder()
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
