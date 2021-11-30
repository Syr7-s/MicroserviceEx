package com.syrisa.webappbff.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.syrisa.webappbff.Gender.Gender;
import com.syrisa.webappbff.dto.StudentDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student implements Entity {
    private Long studentID;
    private Long studentNumber;
    private String studentName;
    private String studentLastName;
    private Gender studentGender;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate studentBirthDate;
    private Address address;

    public StudentDto toStudentDto(){
        return StudentDto.builder()
                .studentID(this.studentID)
                .studentNumber(this.studentNumber)
                .studentName(this.studentName)
                .studentLastName(this.studentLastName)
                .studentGender(this.studentGender)
                .studentBirthDate(this.studentBirthDate)
                .address(this.address)
                .build();
    }

}
