package com.syrisa.webappbff.entity;


import com.syrisa.webappbff.Gender.Gender;
import com.syrisa.webappbff.dto.InstructorDto;
import lombok.Builder;
import lombok.Data;


import java.time.LocalDate;

@Data
@Builder
public class Instructor implements Entity {
    private Long instructorID;
    private String instructorName;
    private String instructorLastName;
    private Gender instructorGender;
    private LocalDate instructorBirthDate;
    private Address address;

    public InstructorDto toInstructorDto(){
        return InstructorDto.builder()
                .instructorID(this.instructorID)
                .instructorName(this.instructorName)
                .instructorLastName(this.instructorLastName)
                .instructorGender(this.instructorGender)
                .instructorBirthDate(this.instructorBirthDate)
                .address(this.address)
                .build();
    }
}
