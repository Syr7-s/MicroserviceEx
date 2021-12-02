package com.syrisa.webappbff.service;

import com.syrisa.webappbff.entity.Entity;

public interface Service <T extends Entity>{
    T create(T t);
    T update(T t);
    <V extends Number> String  delete(V v);
    <V extends Number> T getById(V v);

}
