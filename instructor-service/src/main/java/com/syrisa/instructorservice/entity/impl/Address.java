package com.syrisa.instructorservice.entity.impl;

import com.syrisa.instructorservice.entity.Entity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Address implements Entity {
    @Id
    private Long addressID;
    private String street;
    private String number;
    private String city;
    private int zipcode;
}
