package com.syrisa.webappbff.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {
    private Long addressID;
    private String street;
    private String number;
    private String city;
    private int zipcode;
}
