package com.syrisa.studentservice.entity;

import com.syrisa.studentservice.entity.impl.Entity;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class StudentLectureInfo  implements Entity {
    private Long studentNumber;
    private String studentLectureCode;
}
