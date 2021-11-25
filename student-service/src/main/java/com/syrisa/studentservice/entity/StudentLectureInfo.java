package com.syrisa.studentservice.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
@Builder
public class StudentLectureInfo {
    @Id
    private Long studentLectureInfoID;
    private List<String> lectureCode;
    private String studentNameLastName;
    private String lectureCountSameStudent;
}
