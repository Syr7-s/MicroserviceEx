package com.syrisa.studentservice.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.syrisa.studentservice.dto.StudentDto;
import com.syrisa.studentservice.entity.impl.Entity;
import com.syrisa.studentservice.utility.enums.Gender.Gender;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Builder
@Document
public class Student implements Entity {
    private Long studentID;
    private String studentName;
    private String studentLastName;
    private Gender studentGender;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate studentBirthDate;
    private Address address;

    public StudentDto toStudentDto(){
        return StudentDto.builder()
                .studentID(this.studentID)
                .studentName(this.studentName)
                .studentLastName(this.studentLastName)
                .studentGender(this.studentGender)
                .studentBirthDate(this.studentBirthDate)
                .address(this.address)
                .build();
    }

}
