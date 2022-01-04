package com.syrisa.instructorlectureservice.entity.impl;


import com.syrisa.instructorlectureservice.dto.InstructorLecDto;
import com.syrisa.instructorlectureservice.entity.Entity;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;

@Data
@Builder
@Document
public class InstructorLec implements Entity {
    @Id
    private Long instructorLecID;
    private String lectureCode;
    private Long instructorID;
    private String instructorNameSurname;
    @Min(value = 10, message = "Student capacity should not be lower than 10.")
    @Max(value = 50, message = "Student capacity should not exceed 30")
    private int studentCapacity;
    @Field(value = "0")
    private int studentCount;
    private LocalDate openDate;

    public InstructorLecDto toInstructorLecDto() {
        return InstructorLecDto.builder()
                .instructorLecID(this.instructorLecID)
                .lectureCode(this.lectureCode)
                .instructorID(this.instructorID)
                .instructorNameSurname(this.instructorNameSurname)
                .studentCapacity(this.studentCapacity)
                .openDate(this.openDate)
                .build();
    }
}
