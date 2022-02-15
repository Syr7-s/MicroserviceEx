package com.syrisa.webappbff.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.syrisa.webappbff.Gender.Gender;
import com.syrisa.webappbff.entity.Address;
import com.syrisa.webappbff.entity.Instructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class InstructorDto {
    private Long instructorID;
    private String instructorName;
    private String instructorLastName;
    private Gender instructorGender;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate instructorBirthDate;
    private Address address;

    public Instructor toInstructor() {
        return Instructor.builder()
                .instructorID(this.instructorID)
                .instructorName(this.instructorName)
                .instructorLastName(this.instructorLastName)
                .instructorGender(this.instructorGender)
                .instructorBirthDate(this.instructorBirthDate)
                .address(this.address)
                .build();
    }
}
