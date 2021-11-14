package com.syrisa.instructorservice.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.syrisa.instructorservice.utility.enums.gender.Gender;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Builder
@Document
public class Instructor {
    private Long instructorID;
    private String instructorName;
    private String instructorLastName;
    private Gender instructorGender;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate instructorBirthDate;


}
