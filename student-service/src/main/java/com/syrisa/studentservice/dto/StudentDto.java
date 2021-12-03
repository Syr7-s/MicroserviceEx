package com.syrisa.studentservice.dto;


import com.syrisa.studentservice.entity.Address;
import com.syrisa.studentservice.entity.Student;
import com.syrisa.studentservice.utility.enums.Gender.Gender;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
@Data
@Builder
public class StudentDto {
    private Long studentID;
    private Long studentNumber;
    private String studentName;
    private String studentLastName;
    private Gender studentGender;
    private LocalDate studentBirthDate;
    private Address address;

    public Student toStudent(){
        return Student.builder()
                .studentID(this.studentID)
                .studentName(this.studentName)
                .studentNumber(this.studentNumber)
                .studentLastName(this.studentLastName)
                .studentGender(this.studentGender)
                .studentBirthDate(this.studentBirthDate)
                .address(this.address)
                .build();
    }

}
