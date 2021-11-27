package com.syrisa.generateservice.service;

public interface Generate <T>{
    T generate(int numLength);

    String generate(String prefix,Short size);
}
