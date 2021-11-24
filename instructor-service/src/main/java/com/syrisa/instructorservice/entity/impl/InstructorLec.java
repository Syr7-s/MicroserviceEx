package com.syrisa.instructorservice.entity.impl;

import com.syrisa.instructorservice.annotations.StudentCapacity;
import com.syrisa.instructorservice.dto.InstructorLecDto;
import com.syrisa.instructorservice.entity.Entity;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@Builder
@Document
public class InstructorLec implements Entity {
    @Id
    private Long instructorLecID;
    @NotBlank(message = "lectureCode is mandatory")
    private String lectureCode;
    @NotBlank(message = "instructorID is mandatory")
    private String instructorID;
    @NotBlank(message = "instructorNameSurname is mandatory")
    private String instructorNameSurname;
    @NotBlank(message = "studentCapacity is mandatory")
    @Min(value = 10,message = "studentCapacity Min 10")
    @Max(value = 25,message = "studentCapacity Max 25")
    @StudentCapacity
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
