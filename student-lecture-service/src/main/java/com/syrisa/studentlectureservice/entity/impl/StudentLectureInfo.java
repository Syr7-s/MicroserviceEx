package com.syrisa.studentlectureservice.entity.impl;

import com.syrisa.studentlectureservice.entity.Entity;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class StudentLectureInfo  implements Entity {
    private Long studentNumber;
    private String studentLectureCode;
}
