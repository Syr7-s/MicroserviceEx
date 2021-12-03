package com.syrisa.webappbff.dto;



import com.syrisa.webappbff.Gender.Gender;
import com.syrisa.webappbff.entity.Address;
import com.syrisa.webappbff.entity.Student;
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
                .studentNumber(this.studentNumber)
                .studentName(this.studentName)
                .studentLastName(this.studentLastName)
                .studentGender(this.studentGender)
                .studentBirthDate(this.studentBirthDate)
                .address(this.address)
                .build();
    }

}
