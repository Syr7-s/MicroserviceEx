package com.syrisa.instructorservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Address {
    @Id
    private Long addressID;
    private String street;
    private String number;
    private String city;
    private int zipcode;
}
