package com.syrisa.webappbff.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentLectureInfo  implements Entity {
    private Long studentNumber;
    private String studentLectureCode;
}
