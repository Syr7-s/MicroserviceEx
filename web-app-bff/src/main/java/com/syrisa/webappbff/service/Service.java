package com.syrisa.webappbff.service;

import com.syrisa.webappbff.entity.Entity;

public interface Service<T extends Entity, V extends Number> {
    T create(T t);

    T update(T t);

    String delete(V id);

    T getById(V id);
}
